package com.example.demo.web;

import com.example.demo.domain.Member;
import com.example.demo.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> findAll(Pagination pageNation){
        return memberRepository.findAll(pageNation);
    }
    public int count(){
        return memberRepository.count();
    }
}
