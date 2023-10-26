package com.example.demo.web;

import com.example.demo.domain.Member;
import com.example.demo.dto.Pagination1;
import com.example.demo.dto.SearchDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
public class MemberController {

    private final MemberService memberService;
//    @GetMapping("/member")
//    public String findAll(@RequestParam(value="currentPage", defaultValue = "1") int currentPage, Model model){
//        int count = memberService.count();
//        log.info("currentPAge={}",currentPage);
//        Pagination111 pagination  = new Pagination111(currentPage,count);
//        log.info("pagination={}",pagination);
//        List<Member> members = memberService.findAll(pagination);
//        model.addAttribute("members", members);
//        model.addAttribute("currentPage",currentPage);
//        model.addAttribute("pn",pagination);
//        return "member/findAll";
//    }
//

    @GetMapping("/member")
    public String findAll(@ModelAttribute("searchDTO")SearchDTO searchDTO, @RequestParam(value="currentPage", defaultValue = "1")int currentPage, Model model){
        System.out.println("currentPage = " + currentPage);
        Pagination1 pageNation = new Pagination1(currentPage,memberService.count());
        searchDTO.setPagination(pageNation);
        List<Member> members = memberService.findAll(searchDTO);
        model.addAttribute("members",members);
        model.addAttribute("page",currentPage);
        model.addAttribute("pn",pageNation);
        return "member/findAll";
    }
}
