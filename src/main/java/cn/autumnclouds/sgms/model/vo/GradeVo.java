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
}
