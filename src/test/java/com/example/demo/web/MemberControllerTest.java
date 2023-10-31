package com.example.demo.web;

import com.example.demo.entity.dao.MemberSave;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class MemberControllerTest {
    private final MemberService memberService;
    @Autowired
    public MemberControllerTest(MemberService memberService) {
        this.memberService = memberService;
    }

    @BeforeEach
    void delete(){
       memberService.memberSave(new MemberSave("test1","test1"));
    }

    @Test
    @DisplayName("저장 후 아이디 조회시 빈값 여부t")
    void test1(){
        Assertions.assertThat(memberService.findByLoginId("test1")).isFalse();
    }

    @Test
    @DisplayName("저장 test")
    void test2(){
        Assertions.assertThat( memberService.findByMemberFromLoginId("test1")).isNotNull();
    }

    @Test
    @DisplayName("아이디(pk)삭제 테스트")
    void test3(){
        memberService.deleteMember(100L);
        Assertions.assertThat(memberService.findOne(100L)).isNull();
    }


    @Test
    @DisplayName("로그인아이디 삭제 테스트")
    void test4(){
        String loginId= "name55";
        memberService.deleteFromLoginId(loginId);
        Assertions.assertThat(memberService.findByMemberFromLoginId(loginId)).isNull();
    }
    @Test
    @DisplayName("저장 후 삭제 test")
    void test5(){
        Long id = memberService.memberSave(new MemberSave("afeawfa", "awfawefawefw"));
        memberService.deleteMember(id);
        Assertions.assertThat(memberService.findOne(id)).isNull();
    }

    @AfterEach
    void fin(){
        if(!memberService.findByLoginId("test1")){
            memberService.deleteFromLoginId("test1");
        }
    }

}