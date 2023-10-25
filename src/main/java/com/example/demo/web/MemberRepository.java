package com.example.demo.web;

import com.example.demo.domain.Member;
import com.example.demo.dto.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberRepository {
    List<Member> findAll(Pagination pageNation);
    int count();
}
