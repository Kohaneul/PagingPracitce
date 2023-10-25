package com.example.demo.web;

import com.example.demo.domain.Member;
import com.example.demo.dto.Pagination;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public String findAll(@RequestParam(value="page", defaultValue = "1")int currentPage, Model model){

        Pagination pageNation = new Pagination(memberService.count(),currentPage);
        log.info("$$$$$$$$$$$$$$$$$page={}",pageNation);
        List<Member> members = memberService.findAll(pageNation);
        model.addAttribute("members",members);
        model.addAttribute("page",currentPage);
        model.addAttribute("pn",pageNation);

        return "member/findAll";
    }
}
