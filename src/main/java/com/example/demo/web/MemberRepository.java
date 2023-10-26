package com.example.demo.web;

import com.example.demo.domain.Member;
import com.example.demo.dto.SearchDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberRepository {
    List<Member> findAll(SearchDTO searchDTO);
    int count();
}
