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

    @Override
    public String toString() {
        return STR."""
                学生信息：
                学号：\{id}       姓名： \{name}      性别：\{gender == 1 ? "男" : "女"}

                成绩：
                \{gradeVoList.stream().map(GradeVo::toString).reduce("", (a, b) -> a + b + "\n")}

                平均成绩：
                \{gradeVoList.stream().map(GradeVo::getTotalScore).reduce(0d, Double::sum) / gradeVoList.size()}
                """;
    }
}
