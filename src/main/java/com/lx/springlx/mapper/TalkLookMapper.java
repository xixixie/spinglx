package com.lx.springlx.mapper;

import com.lx.springlx.dto.TalkLookDto;
import com.lx.springlx.pojo.SysDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
@Mapper
public interface TalkLookMapper {

    //根据前台传输数据查询
    SysDept querySysDept(@Param("dto") TalkLookDto dto);
    //根据副总id查询 下属门店
    List<SysDept> querySysDeptByPlateId(@Param("dto") TalkLookDto dto);
    //根据id查询信息
    List<SysDept> querySysDeptById(Long id);
    
    SysDept querySysDeptByShopId(@Param("id") Long id);



    SysDept querySysDeptByName(String name);

    Integer queryTalkLookCountByDeptId(@Param("id") Long id);

    //根据部门id 查找部门类型
    Integer queryDeptTypeByDeptId(@Param("id") Integer id);

    List<Integer> queryDeptByParentId(@Param("parentId") Integer parentId);

    //根据板块的id查询所属的所有门店
    List<Integer> queryDeptByPlateId(Integer parentId);

    //根据门店的id查询所属的所有部门
    List<Long> queryDeptByShopId(Long parentId);
}
