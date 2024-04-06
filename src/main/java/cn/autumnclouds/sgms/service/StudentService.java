package cn.autumnclouds.sgms.service;

import cn.autumnclouds.sgms.model.entity.Student;
import cn.autumnclouds.sgms.model.vo.StudentVo;

/**
 * @author Oreki
 * @description 针对表【student】的数据库操作Service
 * @createDate 2024-04-02 15:21:37
 */
public interface StudentService extends Randomizable<Student>, RandomlyAccessibleService<Student> {
    StudentVo packageStudent(Student student);
    StudentVo getStudentVo(long studentId) ;
}
