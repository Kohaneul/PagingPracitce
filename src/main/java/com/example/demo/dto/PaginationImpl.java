package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginationImpl implements Pagination{
    private int currentPage;
    private int totalCount;
    private int totalPage;
    private int startPage;
    private int endPage;
    private int recordSize = 10;
    private int pageSize = 5;
    private int offset;
    private boolean prev  = false;
    private boolean next  = false;

    public PaginationImpl(int currentPage, int totalCount){
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        setting(currentPage,totalCount);
    }

    private void setting(int currentPage, int totalCount) {
        this.totalPage =(int) Math.ceil(totalCount*1.0/recordSize);
        setFirstAndLastPage(currentPage,totalPage);
        setPrevAndNext(startPage,endPage,totalPage);
        setOffset(currentPage,recordSize);
    }
    private void setOffset(int currentPage,int recordSize){
        this.offset = (currentPage-1)*recordSize;
    }

    private void setPrevAndNext(int firstPage, int endPage, int totalPage) {
        if(firstPage>pageSize && endPage<totalPage){
            prev=true;
            next = true;
        }
        else if(firstPage>pageSize && endPage>totalPage)
        {
            prev = true;
            next = false;
        }
        else if(firstPage<pageSize && endPage<totalPage){
            prev = false;
            next = true;
        }
    }

    private void setFirstAndLastPage(int currentPage,int totalPage){
        int c = currentPage/pageSize;
        this.startPage = currentPage%pageSize ==0 ? (c-1)*pageSize+1 : c*pageSize+1;
        this.endPage = Math.min(startPage+pageSize-1,totalPage);
    }
}
