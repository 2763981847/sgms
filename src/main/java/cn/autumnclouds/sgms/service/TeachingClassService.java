package cn.autumnclouds.sgms.service;

import cn.autumnclouds.sgms.model.entity.TeachingClass;
import cn.autumnclouds.sgms.model.vo.TeachingClassVo;

import java.util.List;

/**
 * @author Oreki
 * @description 针对表【teaching_class】的数据库操作Service
 * @createDate 2024-04-02 15:21:37
 */
public interface TeachingClassService extends Randomizable<TeachingClass>, RandomlyAccessibleService<TeachingClass> {
    List<TeachingClass> randomGenerateWithFixedCourse(long courseId, int count);

    List<TeachingClass> listTeachingClassesInSameCourse(long teachingClassId);

    TeachingClassVo packageTeachingClass(TeachingClass teachingClass);
}
