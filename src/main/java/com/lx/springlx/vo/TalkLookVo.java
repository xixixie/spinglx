package com.lx.springlx.vo;

import com.lx.springlx.pojo.SysDept;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 返回前台参数
 *  根据传入部门的名称去找下级 并返回所属下的部门id 部门名称 部门带看数量  所有部门id
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalkLookVo implements Serializable {
    private List<Integer> ids;
    //部门ID
    private Long deptId;
    //部门名称
    private String deptName;
    //部门带看数量
    private int deptTalkLookAmount;


    //门店ID
    private Long shopId;
    //门店名称
    private String shopName;
    //门店带看数量
    private int shopTalkLookAmount;


    //板块Id
    private Long plateId;
    //板块名称
    private String plateName;
    //板块带看数量
    private int plateTalkLookAmount;

    private List talkLookVoList;


    private List<TalkVo> list;

    private Map plateMap ;
    private Map shopMap ;
    private Map deptMap ;

    private String msg;

    //下级
    private Map<String, List<SysDept>> children;



}
