package cn.autumnclouds.sgms.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author Fu Qiujie
 * @since 2024/4/8
 */
@Data
public class TeachingClassVo {
    private Long id;

    private Long teacherId;

    private String teacherName;

    private Long courseId;

    private String courseName;

    private Integer totalStudent;

    private String semester;

    @Override
    public String toString() {
        return STR."""
                教学班信息：
                教学班号：\{id}       课程： \{courseName}      教师：\{teacherName}      总人数：\{totalStudent}      学期：\{semester}
                """;
    }
}
