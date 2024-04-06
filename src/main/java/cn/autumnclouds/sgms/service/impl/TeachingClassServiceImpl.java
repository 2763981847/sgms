package cn.autumnclouds.sgms.service.impl;

import cn.autumnclouds.sgms.mapper.TeachingClassMapper;
import cn.autumnclouds.sgms.model.entity.Course;
import cn.autumnclouds.sgms.model.entity.Teacher;
import cn.autumnclouds.sgms.model.entity.TeachingClass;
import cn.autumnclouds.sgms.service.CourseService;
import cn.autumnclouds.sgms.service.TeacherService;
import cn.autumnclouds.sgms.service.TeachingClassService;
import cn.autumnclouds.sgms.util.RandomUtils;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Oreki
 * @description 针对表【teaching_class】的数据库操作Service实现
 * @createDate 2024-04-02 15:21:37
 */
@Service
public class TeachingClassServiceImpl extends ServiceImpl<TeachingClassMapper, TeachingClass>
        implements TeachingClassService {
    @Resource
    private CourseService courseService;
    @Resource
    private TeacherService teacherService;

    @Override
    public TeachingClass randomGenerate() {
        TeachingClass teachingClass = new TeachingClass();
        teachingClass.setTeacherId(teacherService.random(Teacher::getId));
        teachingClass.setCourseId(courseService.random(Course::getId));
        teachingClass.setTotalStudent(0);
        teachingClass.setSemester(RandomUtils.randomSemester());
        return teachingClass;
    }

    @Override
    public List<TeachingClass> randomGenerateWithFixedCourse(long courseId, int count) {
        return teacherService.random(count, Teacher::getId).stream().map(teacherId -> {
            TeachingClass teachingClass = new TeachingClass();
            teachingClass.setTeacherId(teacherId);
            teachingClass.setCourseId(courseId);
            teachingClass.setTotalStudent(0);
            teachingClass.setSemester(RandomUtils.randomSemester());
            return teachingClass;
        }).toList();
    }

    @Override
    public List<TeachingClass> listTeachingClassesInSameCourse(long teachingClassId) {
        TeachingClass teachingClass = this.getById(teachingClassId);
        if (teachingClass == null) {
            return List.of();
        }
        return this.lambdaQuery().eq(TeachingClass::getCourseId, teachingClass.getCourseId()).list();
    }
}




