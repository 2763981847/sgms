package cn.autumnclouds.sgms.service.impl;

import cn.autumnclouds.sgms.model.entity.Course;
import cn.autumnclouds.sgms.util.RandomUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.autumnclouds.sgms.service.CourseService;
import cn.autumnclouds.sgms.mapper.CourseMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Oreki
 * @description 针对表【course】的数据库操作Service实现
 * @createDate 2024-04-02 15:21:37
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
        implements CourseService {
    @Override
    public List<Course> randomGenerate(int count) {
        return RandomUtils.randomCourseName(count).parallelStream().map(name -> {
            Course course = new Course();
            course.setName(name);
            return course;
        }).collect(Collectors.toList());
    }

    @Override
    public Course randomGenerate() {
        return randomGenerate(1).get(0);
    }
}




