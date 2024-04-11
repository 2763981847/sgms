package cn.autumnclouds.sgms.service.impl;

import cn.autumnclouds.sgms.mapper.GradeMapper;
import cn.autumnclouds.sgms.model.entity.Grade;
import cn.autumnclouds.sgms.model.entity.TeachingClass;
import cn.autumnclouds.sgms.model.vo.GradeVo;
import cn.autumnclouds.sgms.service.CourseService;
import cn.autumnclouds.sgms.service.GradeService;
import cn.autumnclouds.sgms.service.StudentService;
import cn.autumnclouds.sgms.service.TeachingClassService;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Oreki
 * @description 针对表【grade】的数据库操作Service实现
 * @createDate 2024-04-02 15:21:37
 */
@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade>
        implements GradeService {
    @Resource
    private TeachingClassService teachingClassService;

    @Resource
    @Lazy
    private StudentService studentService;

    @Resource
    private CourseService courseService;

    /**
     * 选课
     *
     * @param studentId       学生ID
     * @param teachingClassId 教学班ID
     */
    @Override
    public void selectCourse(long studentId, long teachingClassId) {
        List<Long> ids = teachingClassService.listTeachingClassesInSameCourse(teachingClassId).stream().map(TeachingClass::getId).toList();
        if (this.lambdaQuery().eq(Grade::getStudentId, studentId).in(Grade::getTeachingClassId, ids).count() > 0) {
            // 已选过该课程
            return;
        }
        Grade grade = new Grade();
        grade.setStudentId(studentId);
        grade.setTeachingClassId(teachingClassId);
        teachingClassService.lambdaUpdate().eq(TeachingClass::getId, teachingClassId)
                .setSql("total_student = total_student + 1")
                .update();
        this.save(grade);
    }

    @Override
    public List<GradeVo> listGradeVoByStudentId(long studentId) {
        return this.lambdaQuery().eq(Grade::getStudentId, studentId).list()
                .stream()
                .map(this::packageGradeVo)
                .collect(Collectors.toList());
    }

    @Override
    public List<GradeVo> listGradeVoByTeachingClassId(long teachingClassId) {
        return this.lambdaQuery().eq(Grade::getTeachingClassId, teachingClassId).list()
                .stream()
                .map(this::packageGradeVo)
                .collect(Collectors.toList());
    }

    private GradeVo packageGradeVo(Grade grade) {
        GradeVo gradeVo = BeanUtil.copyProperties(grade, GradeVo.class);
        gradeVo.setTotalScore(GradeService.calculateTotalScore(grade));
        gradeVo.setStudentName(studentService.getById(grade.getStudentId()).getName());
        Long courseId = teachingClassService.getById(grade.getTeachingClassId()).getCourseId();
        gradeVo.setCourseName(courseService.getById(courseId).getName());
        return gradeVo;
    }


}




