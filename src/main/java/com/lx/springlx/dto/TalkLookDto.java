package com.lx.springlx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The type Talk look vto.
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalkLookDto {
    /**
     * 带看开始时间
     */
    private String startTime;
    /**
     * 带看结束时间
     */
    private String endTime;
    /**
     * 前台传入的部门Id
     * 前台传入的部门类型
     * 前台传入的部门名称(多选)
     */
    private Long typeId;
    private String type;
    private String deptName;


    public String getStartTime() {
        return this.startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public Long getTypeId() {
        return this.typeId;
    }

    public String getType() {
        return this.type;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TalkLookDto)) return false;
        final TalkLookDto other = (TalkLookDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$startTime = this.getStartTime();
        final Object other$startTime = other.getStartTime();
        if (this$startTime == null ? other$startTime != null : !this$startTime.equals(other$startTime)) return false;
        final Object this$endTime = this.getEndTime();
        final Object other$endTime = other.getEndTime();
        if (this$endTime == null ? other$endTime != null : !this$endTime.equals(other$endTime)) return false;
        final Object this$typeId = this.getTypeId();
        final Object other$typeId = other.getTypeId();
        if (this$typeId == null ? other$typeId != null : !this$typeId.equals(other$typeId)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        final Object this$deptName = this.getDeptName();
        final Object other$deptName = other.getDeptName();
        if (this$deptName == null ? other$deptName != null : !this$deptName.equals(other$deptName)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TalkLookDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $startTime = this.getStartTime();
        result = result * PRIME + ($startTime == null ? 43 : $startTime.hashCode());
        final Object $endTime = this.getEndTime();
        result = result * PRIME + ($endTime == null ? 43 : $endTime.hashCode());
        final Object $typeId = this.getTypeId();
        result = result * PRIME + ($typeId == null ? 43 : $typeId.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $deptName = this.getDeptName();
        result = result * PRIME + ($deptName == null ? 43 : $deptName.hashCode());
        return result;
    }

    public String toString() {
        return "TalkLookDto(startTime=" + this.getStartTime() + ", endTime=" + this.getEndTime() + ", typeId=" + this.getTypeId() + ", type=" + this.getType() + ", deptName=" + this.getDeptName() + ")";
    }
}
