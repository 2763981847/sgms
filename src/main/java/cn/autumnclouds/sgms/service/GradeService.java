package cn.autumnclouds.sgms.service;

import cn.autumnclouds.sgms.model.entity.Grade;
import cn.autumnclouds.sgms.model.vo.GradeVo;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Oreki
 * @description 针对表【grade】的数据库操作Service
 * @createDate 2024-04-02 15:21:37
 */
public interface GradeService extends IService<Grade> {
    void selectCourse(long studentId, long teachingClassId);

    List<GradeVo> listGradeVoByStudentId(long studentId);

    List<GradeVo> listGradeVoByTeachingClassId(long teachingClassId);

    static void setGradeRandomly(Grade grade) {
        grade.setRegularScore(RandomUtil.randomInt(0, 101));
        grade.setMidtermScore(RandomUtil.randomInt(0, 101));
        grade.setFinalScore(RandomUtil.randomInt(0, 101));
        grade.setExperimentalScore(RandomUtil.randomInt(0, 101));
    }

    static Double calculateTotalScore(Grade grade) {
        return grade.getRegularScore() * 0.2 + grade.getMidtermScore() * 0.2 + grade.getFinalScore() * 0.4 + grade.getExperimentalScore() * 0.2;
    }

}
