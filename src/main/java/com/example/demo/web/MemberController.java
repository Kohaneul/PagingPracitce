package com.example.demo.web;

import com.example.demo.dto.Pagination;
import com.example.demo.dto.PaginationImpl;
import com.example.demo.dto.SearchDTO;
import com.example.demo.entity.Member;
import com.example.demo.entity.dao.MemberSave;
import com.example.demo.entity.dao.MemberUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public String memberAll(@ModelAttribute("searchDTO")SearchDTO searchDTO,
                            @RequestParam(value="currentPage", defaultValue = "1")int currentPage, Model model){
        int count = memberService.count();
        Pagination pn = new PaginationImpl(currentPage,count);
        searchDTO.setPagination(pn);
        List<Member> members = memberService.findAll(searchDTO);
        model.addAttribute("members",members);
        model.addAttribute("pn",pn);
        model.addAttribute("currentPage",currentPage);
        return "member/findAll";
    }
    @GetMapping("/{id}")
    public String findOne(@PathVariable("id")Long id, Model model){
        Member member = memberService.findOne(id);
        model.addAttribute("member",member);
        return "member/findOne";
    }
    @GetMapping("/save")
    public String saveMember(@ModelAttribute("member")MemberSave memberSave){
        return "member/saveMember";
    }
    @PostMapping("/save")
    public String saveMember(@Valid @ModelAttribute("member")MemberSave memberSave, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        setGlobalError(memberSave.getLoginId(),bindingResult);
        if(bindingResult.hasErrors()){
            return "member/saveMember";

        }
        Long id = memberService.memberSave(memberSave);
        redirectAttributes.addAttribute("id",id);
        return "redirect:/member/{id}";
    }
    @GetMapping("/{id}/update")
    public String updateMember(@PathVariable("id") Long id, @ModelAttribute("member")MemberUpdate memberUpdate){
        Member member = memberService.findOne(id);
        memberUpdate.setId(id);
        memberUpdate.setName(member.getName());
        memberUpdate.setLoginId(member.getLoginId());
        return "member/updateMember";
    }
    @PostMapping("/{id}/update")
    public String updateMember(@PathVariable("id") Long id,@Valid @ModelAttribute("member")MemberUpdate memberUpdate,BindingResult bindingResult, RedirectAttributes redirectAttributes){
        setGlobalError(memberUpdate.getLoginId(),bindingResult);
        if(bindingResult.hasErrors()){
            return "member/updateMember";
        }
        memberService.memberUpdate(memberUpdate);
        redirectAttributes.addAttribute("id",id);
        return "redirect:/member/"+id;
    }

    private void setGlobalError(String id,BindingResult bindingResult) {
        if(!memberService.findByLoginId(id)){
            bindingResult.addError(new FieldError("globalError","loginId","존재하는 아이디입니다. 다시입력해주세요"));
        }
    }

    @GetMapping("/{id}/delete")
    public String deleteMember(@PathVariable("id")Long id){
        Member member = memberService.findOne(id);
        memberService.deleteMember(id);
        return "redirect:/member";
    }

}
