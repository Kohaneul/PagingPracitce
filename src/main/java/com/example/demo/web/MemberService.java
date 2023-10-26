package com.example.demo.web;

import com.example.demo.domain.Member;
import com.example.demo.dto.Pagination;
import com.example.demo.dto.SearchDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> findAll(SearchDTO searchDTO){
        return memberRepository.findAll(searchDTO);
    }
    public int count(){
        return memberRepository.count();
    }
}
