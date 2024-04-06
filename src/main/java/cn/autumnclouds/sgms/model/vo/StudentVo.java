package cn.autumnclouds.sgms.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

/**
 * @author Fu Qiujie
 * @since 2024/4/6
 */
@Data
public class StudentVo {
    private Long id;

    private String name;

    private Integer gender;

    private List<GradeVo> gradeVoList;
}
