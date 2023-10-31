package com.example.demo.web;

import com.example.demo.dto.SearchDTO;
import com.example.demo.entity.Member;
import com.example.demo.entity.dao.MemberSave;
import com.example.demo.entity.dao.MemberUpdate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Mapper
public interface MemberRepository {
    List<Member> findAll(SearchDTO searchDTO);
    int count();
    Member findOne(Long id);
    @Transactional
    Long memberSave(MemberSave memberSave);
    @Transactional
    void memberUpdate(MemberUpdate memberUpdate);
    @Transactional
    void deleteMember(Long id);
    @Transactional
    void deleteFromLoginId(String loginId);
    Boolean findByLoginId(String loginId);
    Long findByMemberFromLoginId(String loginId);
}
