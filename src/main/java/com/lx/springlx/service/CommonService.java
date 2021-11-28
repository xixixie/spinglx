package com.lx.springlx.service;

import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 2021/11/5 18:13
 * 公共 查询所有部门表信息
 *
 *
 * @author Wangcw
 **/
@Service
public interface CommonService {
    void getExcel(List<?> ts);
}
