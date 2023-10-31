package com.example.demo.web;

import com.example.demo.dto.SearchDTO;
import com.example.demo.entity.Member;
import com.example.demo.entity.dao.MemberSave;
import com.example.demo.entity.dao.MemberUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Boolean findByLoginId(String loginId){
        return memberRepository.findByLoginId(loginId);
    }
    public Long findByMemberFromLoginId(String loginId){
        return memberRepository.findByMemberFromLoginId(loginId);
    }
    public List<Member> findAll(SearchDTO searchDTO){
        return memberRepository.findAll(searchDTO);
    }
    public int count(){
        return memberRepository.count();
    }
    public Long memberSave(MemberSave memberSave){
       return memberRepository.memberSave(memberSave);
    }
    public void memberUpdate(MemberUpdate memberUpdate){
        memberRepository.memberUpdate(memberUpdate);
    }
    public Member findOne(Long id){
       return memberRepository.findOne(id);
    }
    public void deleteMember(Long id){
        memberRepository.deleteMember(id);
    }
    public void deleteFromLoginId(String loginId){
        memberRepository.deleteFromLoginId(loginId);
    }
}
