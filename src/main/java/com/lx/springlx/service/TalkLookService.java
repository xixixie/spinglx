package com.lx.springlx.service;

import com.lx.springlx.dto.TalkLookDto;
import com.lx.springlx.vo.TalkLookVo;

import java.util.List;

/**
 *
 */

public interface TalkLookService {
         // 根据部门id 查看部门带看
        List<TalkLookVo> queryTalkLook(TalkLookDto dto);

        //根据前台数据 查询部门数据
        List<TalkLookVo> queryTalkLook1(TalkLookDto dto);

        List<TalkLookVo> queryTalkLook2(TalkLookDto dto);


}
