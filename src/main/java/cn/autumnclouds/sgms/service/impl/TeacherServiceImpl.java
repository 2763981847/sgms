package cn.autumnclouds.sgms.service.impl;

import cn.autumnclouds.sgms.model.entity.Teacher;
import cn.autumnclouds.sgms.util.RandomUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.autumnclouds.sgms.service.TeacherService;
import cn.autumnclouds.sgms.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

/**
 * @author Oreki
 * @description 针对表【teacher】的数据库操作Service实现
 * @createDate 2024-04-02 15:21:37
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
        implements TeacherService {
    @Override
    public Teacher randomGenerate() {
        Teacher teacher = new Teacher();
        teacher.setName(RandomUtils.randomChineseName());
        return teacher;
    }
}




