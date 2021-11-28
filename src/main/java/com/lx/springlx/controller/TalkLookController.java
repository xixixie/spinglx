package com.lx.springlx.controller;

import com.lx.springlx.dto.TalkLookDto;
import com.lx.springlx.service.TalkLookService;
import com.lx.springlx.vo.TalkLookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 */
@Controller
public class TalkLookController {
    @Autowired
    private TalkLookService talkLookService;

    @GetMapping("/queryTalkLookById")
    @ResponseBody
    public List<TalkLookVo> queryTalkLookById(TalkLookDto dto){
        List<TalkLookVo> talkLookVos = talkLookService.queryTalkLook(dto);
        return talkLookVos;
    }

    @GetMapping("queryTalkLook")
    @ResponseBody
    public List<TalkLookVo> queryTalkLook(TalkLookDto dto){
        List<TalkLookVo> talkLookVos = talkLookService.queryTalkLook1(dto);
        return talkLookVos;
    }

    @GetMapping("queryTalkLook2")
    @ResponseBody
    public List<TalkLookVo> queryTalkLook2(TalkLookDto dto) {
        List<TalkLookVo> talkLookVos = talkLookService.queryTalkLook2(dto);
        return talkLookVos;
    }
}
