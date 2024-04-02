package cn.autumnclouds.sgms.service.impl;

import cn.autumnclouds.sgms.model.entity.Student;
import cn.autumnclouds.sgms.util.RandomUtils;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.autumnclouds.sgms.service.StudentService;
import cn.autumnclouds.sgms.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
 * @author Oreki
 * @description 针对表【student】的数据库操作Service实现
 * @createDate 2024-04-02 15:21:37
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {
    @Override
    public Student randomGenerate() {
        Student student = new Student();
        student.setName(RandomUtils.randomChineseName());
        student.setGender(RandomUtil.randomInt(0, 1));
        return student;
    }
}




