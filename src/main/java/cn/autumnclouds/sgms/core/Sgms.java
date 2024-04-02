package cn.autumnclouds.sgms.core;

import cn.autumnclouds.sgms.service.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Fu Qiujie
 * @since 2024/4/2
 */
@Component
public class Sgms {
    @Resource
    private StudentService studentService;

    @Resource
    private TeachingClassService teachingClassService;

    @Resource
    private GradeService gradeService;

    @Resource
    private TeacherService teacherService;

    @Resource
    private CourseService courseService;


    public void generateData() {
        // 生成学生数据
        studentService.saveBatch(studentService.randomGenerate(100));
        // 生成教师数据
        teacherService.saveBatch(teacherService.randomGenerate(12));
        // 生成课程数据
        courseService.saveBatch(courseService.randomGenerate(6));
        // 生成教学班数据
        teachingClassService.saveBatch(teachingClassService.randomGenerate(12));
    }

    public void selectCourse() {

    }
}
