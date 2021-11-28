package com.lx.springlx.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 */
@AllArgsConstructor
@NoArgsConstructor
public class TalkVo {
    private Integer deptId;
    private String deptName;
    private Integer parentId;
    private List<TalkVo> children;

    public Integer getDeptId() {
        return this.deptId;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public List<TalkVo> getChildren() {
        return this.children;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public void setChildren(List<TalkVo> children) {
        this.children = children;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TalkVo)) return false;
        final TalkVo other = (TalkVo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$deptId = this.getDeptId();
        final Object other$deptId = other.getDeptId();
        if (this$deptId == null ? other$deptId != null : !this$deptId.equals(other$deptId)) return false;
        final Object this$deptName = this.getDeptName();
        final Object other$deptName = other.getDeptName();
        if (this$deptName == null ? other$deptName != null : !this$deptName.equals(other$deptName)) return false;
        final Object this$parentId = this.getParentId();
        final Object other$parentId = other.getParentId();
        if (this$parentId == null ? other$parentId != null : !this$parentId.equals(other$parentId)) return false;
        final Object this$children = this.getChildren();
        final Object other$children = other.getChildren();
        if (this$children == null ? other$children != null : !this$children.equals(other$children)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TalkVo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $deptId = this.getDeptId();
        result = result * PRIME + ($deptId == null ? 43 : $deptId.hashCode());
        final Object $deptName = this.getDeptName();
        result = result * PRIME + ($deptName == null ? 43 : $deptName.hashCode());
        final Object $parentId = this.getParentId();
        result = result * PRIME + ($parentId == null ? 43 : $parentId.hashCode());
        final Object $children = this.getChildren();
        result = result * PRIME + ($children == null ? 43 : $children.hashCode());
        return result;
    }

    public String toString() {
        return "TalkVo(deptId=" + this.getDeptId() + ", deptName=" + this.getDeptName() + ", parentId=" + this.getParentId() + ", children=" + this.getChildren() + ")";
    }
}
