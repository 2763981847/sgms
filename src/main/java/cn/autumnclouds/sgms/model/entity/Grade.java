package cn.autumnclouds.sgms.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName grade
 */
@TableName(value = "grade")
@Data
public class Grade implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     *
     */
    @TableField(value = "student_id")
    private Long studentId;

    /**
     *
     */
    @TableField(value = "teaching_class_id")
    private Long teachingClassId;

    /**
     *
     */
    @TableField(value = "regular_score")
    private Integer regularScore;

    /**
     *
     */
    @TableField(value = "midterm_score")
    private Integer midtermScore;

    /**
     *
     */
    @TableField(value = "experimental_score")
    private Integer experimentalScore;

    /**
     *
     */
    @TableField(value = "final_score")
    private Integer finalScore;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Grade other = (Grade) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()))
                && (this.getTeachingClassId() == null ? other.getTeachingClassId() == null : this.getTeachingClassId().equals(other.getTeachingClassId()))
                && (this.getRegularScore() == null ? other.getRegularScore() == null : this.getRegularScore().equals(other.getRegularScore()))
                && (this.getMidtermScore() == null ? other.getMidtermScore() == null : this.getMidtermScore().equals(other.getMidtermScore()))
                && (this.getExperimentalScore() == null ? other.getExperimentalScore() == null : this.getExperimentalScore().equals(other.getExperimentalScore()))
                && (this.getFinalScore() == null ? other.getFinalScore() == null : this.getFinalScore().equals(other.getFinalScore()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        result = prime * result + ((getTeachingClassId() == null) ? 0 : getTeachingClassId().hashCode());
        result = prime * result + ((getRegularScore() == null) ? 0 : getRegularScore().hashCode());
        result = prime * result + ((getMidtermScore() == null) ? 0 : getMidtermScore().hashCode());
        result = prime * result + ((getExperimentalScore() == null) ? 0 : getExperimentalScore().hashCode());
        result = prime * result + ((getFinalScore() == null) ? 0 : getFinalScore().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", studentId=").append(studentId);
        sb.append(", teachingClassId=").append(teachingClassId);
        sb.append(", regularScore=").append(regularScore);
        sb.append(", midtermScore=").append(midtermScore);
        sb.append(", experimentalScore=").append(experimentalScore);
        sb.append(", finalScore=").append(finalScore);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}