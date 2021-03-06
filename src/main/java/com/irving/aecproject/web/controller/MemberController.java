package com.irving.aecproject.web.controller;

import com.irving.aecproject.web.entity.ScoreRecord;
import com.irving.aecproject.web.service.MemberInfoService;
import com.irving.aecproject.web.service.ScoreRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberInfoService memberInfoService;

    @Autowired
    private ScoreRecordService scoreRecordService;

//    @ResponseBody
//    @RequestMapping("/members")
//    Map<String, Object> queryAllMembers() {
//        Map<String, Object> result = new HashMap<>();
//        result.put("members", memberInfoService.queryAllMembers());
//        return result;
//    }

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

//    @RequestMapping("/page")
//    @ResponseBody
//    List<MemberInfo> queryMembersByPages(@RequestParam("currentpage") Integer currentPage, @RequestParam("pagesize") Integer pageSize){
//        return memberInfoService.queryMembersByPage(currentPage, pageSize);
//    }

    @RequestMapping("/records")
    @ResponseBody
    List<ScoreRecord> queryAllScores(){
//        return scoreRecordService.queryAllRecords();
        return null;
    }
}
