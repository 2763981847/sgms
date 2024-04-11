package cn.autumnclouds.sgms.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author Fu Qiujie
 * @since 2024/4/6
 */
@Data
public class GradeVo {

    private Long studentId;

    private String studentName;

    private Long teachingClassId;

    private String courseName;

    private Integer regularScore;

    private Integer midtermScore;

    private Integer experimentalScore;

    private Integer finalScore;


    private Double totalScore;

    @Override
    public String toString() {
        return STR."""
                科目：\{courseName}   学生：\{studentName}   平时成绩：\{regularScore}   期中成绩：\{midtermScore}   实验成绩：\{experimentalScore}   期末成绩：\{finalScore}   总成绩：\{totalScore}
                """;
    }
}
