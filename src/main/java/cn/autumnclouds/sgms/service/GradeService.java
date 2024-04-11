package cn.autumnclouds.sgms.service;

import cn.autumnclouds.sgms.model.entity.Grade;
import cn.autumnclouds.sgms.model.vo.GradeVo;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;

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

    static String tallyingGrades(List<GradeVo> gradeVos) {
        DoubleStream scoreStream = gradeVos.stream().mapToDouble(GradeVo::getTotalScore);
        DoubleSummaryStatistics summaryStatistics = scoreStream.summaryStatistics();
        // 统计优秀率（不少于九十分）
        long excellentCount = gradeVos.stream().filter(gradeVo -> gradeVo.getTotalScore() >= 90).count();
        double excellentRate = (double) excellentCount / gradeVos.size();
        // 统计合格率（不少于六十分）
        long passCount = gradeVos.stream().filter(gradeVo -> gradeVo.getTotalScore() >= 60).count();
        double passRate = (double) passCount / gradeVos.size();
        return STR."平均分：\{summaryStatistics.getAverage()}，最高分：\{summaryStatistics.getMax()}，最低分：\{summaryStatistics.getMin()}， 优秀率：\{excellentRate}，合格率：\{passRate}";
    }

}
