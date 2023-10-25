package com.example.demo.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PageDTOTest {
    private final int PAGE_PER_RECORD = 10;
    private final int PAGE_PER_QTY = 8;

    @Test
    @DisplayName("페이지 테스트")
    void test1(){
        int currentRecordNo = 61;

        int page = currentRecordNo/PAGE_PER_RECORD+1;
        System.out.println("page = " + page);
    }
    
    @Test
    @DisplayName("현제 페이지")
    void test2(){
        int currentPage = 1;
        int firstPage = (currentPage/PAGE_PER_QTY)*PAGE_PER_QTY+1;
        System.out.println("firstPage = " + firstPage);
    }

    @Test
    @DisplayName("마지막 페이지")
    void test3(){
        int currentPage = 10;
        int firstPage = (currentPage/PAGE_PER_QTY)*PAGE_PER_QTY+1;
        System.out.println("firstPage = " + firstPage);
        System.out.println("lastPage = " + (firstPage+PAGE_PER_QTY-1));

    }
}