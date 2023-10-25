package com.example.demo.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class MemberDTOTest {


    @Test
    @DisplayName("페이지")
    void test(){
        int totalNo = 12;
        int recordNo = 10;
        int ceil = (int) Math.ceil(12 / 10);
        System.out.println("ceil = " + ceil);
    }
    @Test
    void test22(){
        //50개있음
        /*
        * 1~10
        * 11~20
        * 21 ~30
        * 31~40
        * 41~50

        * 50개
        * 50
        *
        * * */



          }
}