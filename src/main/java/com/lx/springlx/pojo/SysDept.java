package com.lx.springlx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysDept implements Serializable {
    private Long deptId;
    private Long userId;
    private String deptType;
    private String deptTel;
    private String deptAddress;
    private String deptCoordinate;
    private Integer tuijianCount;
    private Integer tuijianSumCount;
    private String name;
    private Integer sort;
    private Date createTime;
    private Date updateTime;
    private String delFlag;
    private Integer parentId;
    private Integer tenantId;
    private String deptMode;


}
