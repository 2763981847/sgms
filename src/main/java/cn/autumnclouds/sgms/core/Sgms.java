package cn.autumnclouds.sgms.core;

import cn.autumnclouds.sgms.model.entity.Course;
import cn.autumnclouds.sgms.model.entity.Grade;
import cn.autumnclouds.sgms.model.entity.Student;
import cn.autumnclouds.sgms.model.entity.TeachingClass;
import cn.autumnclouds.sgms.model.vo.StudentVo;
import cn.autumnclouds.sgms.service.*;
import cn.hutool.core.util.RandomUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Fu Qiujie
 * @since 2024/4/2
 */
@Component
public class Sgms {
    @Resource
    public StudentService studentService;

    @Resource
    public TeachingClassService teachingClassService;

    @Resource
    public GradeService gradeService;

    @Resource
    public TeacherService teacherService;

    @Resource
    public CourseService courseService;


    public void generateData(int studentCount, int teacherCount, int courseCount) {
        if (studentCount < 100 || teacherCount < 6 || courseCount < 3) {
            throw new IllegalArgumentException();
        }
        // 生成学生数据
        studentService.saveBatch(studentService.randomGenerate(studentCount));
        // 生成教师数据
        teacherService.saveBatch(teacherService.randomGenerate(teacherCount));
        // 生成课程数据
        List<Course> courses = courseService.randomGenerate(courseCount);
        courseService.saveBatch(courses);
        // 生成教学班数据, 保证每个课程有至少两个教学班
        teachingClassService.saveBatch(courses.stream().map(course -> teachingClassService.randomGenerateWithFixedCourse(course.getId(), RandomUtil.randomInt(2, 4))).flatMap(List::stream).toList());
    }

    public void selectCourse() {
        // 为每个课程安排学生
        courseService.lambdaQuery().select(Course::getId).list().stream().map(Course::getId).forEach(this::selectCourse);
        // 检查是否有学生选课数小于3门，若小于则随机选课
        checkStudentCourse();
    }

    private void checkStudentCourse() {
        // 检查是否有学生选课数小于3门，若小于则随机选课
        List<Student> students = studentService.list().stream().filter(student -> gradeService.lambdaQuery().eq(Grade::getStudentId, student.getId()).count() < 3).toList();
        // 若没有学生选课数小于3门，则返回
        if (CollectionUtils.isEmpty(students)) {
            return;
        }
        // 随机选课
        // 这里再随机选择3个教学班，然后尝试选课，已经选过则无法再选，一次选择三个可以保证至少有一个教学班可以被该学生选择，避免无限递归
        students.forEach(student -> teachingClassService.random(3).forEach(teachingClass -> gradeService.selectCourse(student.getId(), teachingClass.getId())));
        // 递归检查是否仍有学生选课数小于3门，若小于则随机选课
        checkStudentCourse();
    }

    private void selectCourse(long courseId) {
        // 为同一课程下的每个教学班安排学生，保证每个教学班不少于20个人，且同一个课程的教学班不会出现相同的学生
        List<TeachingClass> teachingClasses = teachingClassService.lambdaQuery().eq(TeachingClass::getCourseId, courseId).list();
        List<Student> students = studentService.random(teachingClasses.size() * 20);
        for (int i = 0; i < teachingClasses.size(); i++) {
            List<Student> subList = students.subList(i * 20, (i + 1) * 20);
            TeachingClass teachingClass = teachingClasses.get(i);
            teachingClass.setTotalStudent(20);
            teachingClassService.updateById(teachingClass);
            gradeService.saveBatch(subList.stream().map(student -> {
                Grade grade = new Grade();
                grade.setStudentId(student.getId());
                grade.setTeachingClassId(teachingClass.getId());
                return grade;
            }).toList());
        }
    }

    public void generateGradeRandomly() {
        // 为每个学生随机生成成绩
        gradeService.list().forEach(GradeService::setGradeRandomly);
    }

    public void clearData() {
        gradeService.remove(null);
        teachingClassService.remove(null);
        courseService.remove(null);
        teacherService.remove(null);
        studentService.remove(null);
    }


}
