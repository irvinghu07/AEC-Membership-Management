package com.irving.aecproject.controller;

import com.irving.aecproject.entity.MemberInfo;
import com.irving.aecproject.entity.ScoreRecord;
import com.irving.aecproject.service.MemberInfoService;
import com.irving.aecproject.service.ScoreRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Resource(name = "MemberInfoService")
    private MemberInfoService memberInfoService;

    @Resource(name = "scoreRecordService")
    private ScoreRecordService scoreRecordService;

    @ResponseBody
    @RequestMapping("/members")
    Map<String, Object> queryAllMembers() {
        Map<String, Object> result = new HashMap<>();
        result.put("members", memberInfoService.queryAllMembers());
        return result;
    }

    @RequestMapping("/showMembers")
    String showAllMembers(ModelMap map){
        map.addAttribute("allmembers", memberInfoService.queryAllMembers());
        map.addAttribute("role", "Irving");
        return "members";
    }

    @RequestMapping("/toLogin")
    String toLogin(){
        return "login";
    }

    @RequestMapping("/page")
    @ResponseBody
    List<MemberInfo> queryMembersByPages(@RequestParam("currentpage") Integer currentPage, @RequestParam("pagesize") Integer pageSize){
        return memberInfoService.queryMembersByPage(currentPage, pageSize);
    }

    @RequestMapping("/records")
    @ResponseBody
    List<ScoreRecord> queryAllScores(){
        return scoreRecordService.queryAllRecords();
    }
}
