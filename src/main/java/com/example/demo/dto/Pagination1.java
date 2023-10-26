package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//페이징처리 클래스
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Pagination1 implements Pagination{
    private int recordSize = 10;
    private int pageSize = 5;
    private int startPage= 1;
    private int endPage;
    private int totalPage;
    private int totalCount;
    private boolean prev = false;
    private boolean next = false;
    private int offset;
    private int currentPage;

    public Pagination1(int currentPage, int totalCount) {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        init(currentPage, totalCount);
    }

    //10
    private void init(int currentPage, int totalCount) {
        this.totalPage = (int)Math.ceil(totalCount*1.0/recordSize);
        //현재 3페이지라면 1페이지 , 5페이지라면 1페이지,
        setStartPage(currentPage);
        this.endPage = Math.min(totalPage, startPage + pageSize - 1);
        System.out.println("endPage = " + endPage);
        this.offset = (currentPage -1)*recordSize;
        setBool(startPage,endPage,totalPage);
    }
    private void setStartPage(int currentPage){
        int c = currentPage/pageSize;
        this.startPage = currentPage%pageSize ==0 ? (c-1)*pageSize+1 : c*pageSize+1;
    }

    private void setBool(int startPage, int endPage, int totalPage) {
        if (startPage > pageSize && endPage < totalPage) {
            prev = true;
            next = true;
        } else if (startPage < pageSize && endPage < totalPage) {
            prev = false;
            next = true;
        } else if (startPage > pageSize && endPage > totalPage) {
            prev = true;
            next = false;
        }

    }


}

