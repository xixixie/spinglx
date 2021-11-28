package com.lx.springlx.service.impl;

import com.lx.springlx.contant.DeptConstant;
import com.lx.springlx.dto.TalkLookDto;
import com.lx.springlx.mapper.TalkLookMapper;
import com.lx.springlx.pojo.SysDept;
import com.lx.springlx.service.TalkLookService;
import com.lx.springlx.vo.TalkLookVo;
import com.lx.springlx.vo.TalkVo;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class TalkLookServiceImpl implements TalkLookService {
    @Autowired
    private TalkLookMapper talkLookMapper;

    private DeptConstant deptConstant;
    @Override
    public List<TalkLookVo>  queryTalkLook(TalkLookDto dto) {
        List<TalkLookVo> talkLookVoList = new ArrayList<TalkLookVo>();
        TalkLookVo vo = new TalkLookVo();
        //获取前台传入名称
        String name = dto.getDeptName();
        //查询系统部门表数据
        SysDept sysDept = talkLookMapper.querySysDeptByName(name);
        Long deptId = sysDept.getDeptId();
        //判断传入的机构类型

        if(sysDept.getDeptType().equals(DeptConstant.Dept_TYPE_DEPT)){
            //传入类型为部门
            Integer deptTalkLookAmount = talkLookMapper.queryTalkLookCountByDeptId(deptId);
            System.out.println(deptTalkLookAmount);
            vo.setDeptTalkLookAmount(deptTalkLookAmount);
            vo.setDeptId(deptId);
            vo.setDeptName(name);
            talkLookVoList.add(vo);
            return talkLookVoList;
        }


        // 0 公司 1板块 3门店 4部门 5组 6职能


        //获取是门店类型 查询门店下所有的部门带看量
        if(sysDept.getDeptType().equals(DeptConstant.Dept_TYPE_SHOP)){
                //先查到门店的id   再查询部门的父id为门店id的所有部门
            List<Long> deptIds = talkLookMapper.queryDeptByShopId(deptId);
            Integer shopSum = 0;
            for (Long Id : deptIds) {
                //部门的带看量
                Integer deptTalkLookAmount = talkLookMapper.queryTalkLookCountByDeptId(Id);
                shopSum+=deptTalkLookAmount;
                vo.setDeptTalkLookAmount(deptTalkLookAmount);
                vo.setShopTalkLookAmount(shopSum);
                vo.setShopName(name);
                talkLookVoList.add(vo);
            }
            return talkLookVoList;
        }
        return talkLookVoList;
        //前台传入板块  查询板块下所有的门店和部门
   /*     if(deptTypeID==DeptConstant.Dept_TYPE_PLATE){
            List<TalkLookVo> list = new ArrayList<>();
            List<Integer> shopIds = talkLookMapper.queryDeptByPlateId(deptId);
            for (Integer shopId : shopIds) {
                List<Integer> deptIds = talkLookMapper.queryDeptByShopId(shopId);
                for (Integer id : deptIds) {
                    Integer deptTalkLookAmount = talkLookMapper.queryTalkLookCountByDeptId(id);
                    vo.setDeptTalkLookAmount(deptTalkLookAmount);
                    vo.setDeptName(name);
                    list.add(vo);
                }
            }

        }*/





            //部门类型为0时 查询公司三个大板块所有的带看
      /*  if(deptTypeID==DeptConstant.Dept_TYPE_Company){
                //查询 的三个板块
            List<Integer> plateIds = talkLookMapper.queryDeptByParentId(DeptConstant.Dept_TYPE_PLATE);
            for (Integer plateId : plateIds) {
                //获取集合中板块的id 根据板块的id查询板块所有的门店
                List<Integer> shopIds = talkLookMapper.queryDeptByPlateId(plateId);
                //获取集合中门店的id 根据门店的id查询门店所有的部门
                for (Integer shopId : shopIds) {
                    List<Integer> deptIds = talkLookMapper.queryDeptByShopId(shopId);
                }
            }
        }*/

    }





    @Override
    public List<TalkLookVo> queryTalkLook1(TalkLookDto dto) {
        ArrayList<TalkLookVo> talkLookVos = new ArrayList<>();
        System.out.println(dto);
        //根据前台传入的值 查找Dept数据
        SysDept sysDept = talkLookMapper.querySysDept(dto);

        System.out.println(sysDept);
        if (sysDept==null){
            /*TalkLookVo vo = new TalkLookVo();
            vo.setMsg("条件错误");
            talkLookVos.add(vo);
            return talkLookVos;*/
            return null;
        }

        /**
         *  板块
         *
         * */
        else if(dto.getType().equals(DeptConstant.Dept_TYPE_PLATE)){
            //获取板块下的所有门店
            List<SysDept> sysShops = talkLookMapper.querySysDeptByPlateId(dto);
            //门店信息遍历出来  再根据门店id查找所有的部门
            //所有门店信息
            Map<String, List<SysDept>> collect = sysShops.stream().collect(Collectors.groupingBy(SysDept::getName));
            System.out.println(collect);

            for (SysDept shop : sysShops) {
                //获取所有的部门信息
                List<SysDept> sysDepts = talkLookMapper.querySysDeptById(shop.getDeptId());
                //创建一个Map 键为门店id 值为部门集合
                Map<String, List<SysDept>> collect1 = sysDepts.stream().collect(Collectors.groupingBy(SysDept::getName));
                TalkLookVo vo = new TalkLookVo();
                vo.setShopId(shop.getDeptId());
                vo.setShopName(shop.getName());
                vo.setPlateId(dto.getTypeId());
                vo.setPlateName(dto.getDeptName());
                vo.setPlateMap(collect1);
                //Map(collect1);
                talkLookVos.add(vo);
            }
            return talkLookVos;
        }
        /**
         *  门店
         *
         * */
        else if(dto.getType().equals(DeptConstant.Dept_TYPE_SHOP)){
            //下查获取门店下所有部门
            SysDept sysDept1 = talkLookMapper.querySysDept(dto); //传入门店的信息
            //上查信息(板块)
            SysDept sysDept2 = talkLookMapper.querySysDeptByShopId(sysDept1.getParentId().longValue());
            List<SysDept> sysDepts = talkLookMapper.querySysDeptByPlateId(dto);
            for (SysDept dept : sysDepts) {
                TalkLookVo vo = new TalkLookVo();
                vo.setDeptId(dept.getDeptId());
                vo.setDeptName(dept.getName());
                vo.setShopId(dto.getTypeId());
                vo.setShopName(dto.getDeptName());
                vo.setPlateName(sysDept2.getName());
                vo.setPlateId(sysDept2.getDeptId());
                talkLookVos.add(vo);
            }
            return talkLookVos;
        }
        /**
         * 部门
         *
         * */
        else if(dto.getType().equals(DeptConstant.Dept_TYPE_DEPT)){
            SysDept sysDept1 = talkLookMapper.querySysDept(dto);
            //获取父id >>>> 门店id
            Long parentId = sysDept1.getParentId().longValue();
            //上查 根据部门信息查询门店信息
            SysDept shop = talkLookMapper.querySysDeptByShopId(parentId);
            //上查 根据门店信息查板块
            SysDept plate = talkLookMapper.querySysDeptByShopId(shop.getParentId().longValue());
            System.out.println("sysDept2========"+shop);
            TalkLookVo vo = new TalkLookVo();
            vo.setDeptId(dto.getTypeId());
            vo.setDeptName(sysDept1.getName());
            vo.setShopId(parentId);
            vo.setShopName(shop.getName());
            vo.setPlateName(plate.getName());
            vo.setPlateId(plate.getDeptId());
            talkLookVos.add(vo);
        }
        return talkLookVos;
    }










    @Override
    public List<TalkLookVo> queryTalkLook2(TalkLookDto dto) {
        ArrayList<TalkLookVo> talkLookVos = new ArrayList<>();
        TalkLookVo vo =new TalkLookVo();
        //点击公司
       /* if (dto.getType().equals(DeptConstant.Dept_TYPE_Company)){

            //公司信息
            SysDept company = talkLookMapper.querySysDept(dto);
            //查询出三个板块信息
            List<SysDept> plates = talkLookMapper.querySysDeptById(dto.getTypeId());
            //根据名字对板块排序
            //key板块名字 value 板块信息
            //Map<String, List<SysDept>> plateMap = plates.stream().collect(Collectors.groupingBy(sysDept -> sysDept.getName()));
            plates.stream().filter(vo -> "0".equals(vo.getParentId())).peek()


           *//* for (SysDept plate : plates) {
                //查询所有的门店信息
                TalkLookVo vo1 = new TalkLookVo();
                 shops = talkLookMapper.querySysDeptById(plate.getDeptId());
                Map<String, List<SysDept>> shopMap = shops.stream().collect(Collectors.groupingBy(sysDept -> sysDept.getName()));
                vo1.setShopMap(shopMap);
                talkLookVos.add(vo1);
            }*//*

           *//* for (SysDept shop : shops) {
                //获取所有的部门信息
                TalkLookVo vo2 = new TalkLookVo();
                List<SysDept> sysDepts = talkLookMapper.querySysDeptById(shop.getDeptId());
                Map<String, List<SysDept>> deptMap = sysDepts.stream().collect(Collectors.groupingBy(sysDept -> sysDept.getName()+ RandomUtil.randomNumbers(2)));
                vo2.setDeptMap(deptMap);
                talkLookVos.add(vo2);
            }*//*
            talkLookVos.add(vo);
            return talkLookVos;
        }*/

        return null;
    }

    /**
     *
     * 动态递归建立部门树
     * */
    private List<TalkVo> getChildrens(TalkVo children,List<TalkVo> talkVos){
    return talkVos.stream().filter(child -> child.getParentId().intValue()==children.getDeptId().intValue())
        .peek(child -> child.setChildren(getChildrens(child,talkVos))).collect(Collectors.toList());
    }




}
