package com.example.demo.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PaginationTest {

    @Test
    void test1(){
        int totalCount= 12;
        int recordSize = 10;
        int ceil = (int) Math.ceil(totalCount*1.0 / recordSize);
        Assertions.assertThat(ceil).isEqualTo(2);
    }
    @Test
    void test2(){
        int currentPage = 31;
        int pageSize = 5;
        //1 ~ 5 , 6~10, 11~
        //6

        int firstPage = currentPage%pageSize==0 ? ((currentPage/pageSize)-1)*pageSize+1 : (currentPage/pageSize)*pageSize+1;
        Assertions.assertThat(firstPage).isEqualTo(31);
    }
}