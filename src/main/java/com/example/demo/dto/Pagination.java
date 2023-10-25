package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Pagination {
    private int recordSize = 10;
    private int pageSize = 5;
    private int totalCount;
    private int currentPage;
    private int startPage = 1;
    private int endPage;
    private int totalPage;
    private boolean prev = false;
    private boolean next = false;
    private int offset;

    public Pagination(final int totalCount, final int currentPage){
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        setTotalPage(totalCount);
        setStartPage(this.startPage,currentPage,pageSize);
        setEndPage(this.startPage,this.pageSize,this.totalPage);
        setPrev(this.endPage,this.totalPage);
        setNext(endPage,totalPage);
        setOffSet(currentPage,recordSize);
    }
    public void setTotalPage(int totalCount){
        this.totalPage = (int)Math.ceil(totalCount*1.0/recordSize);
    }
    public void setStartPage(int startPage, int currentPage,int pageSize){
        //현재 3페이지일때 첫페이지를 구해라
        //
        this.startPage = startPage + currentPage/pageSize;

    }
    public void setEndPage(int startPage, int pageSize, int totalPage){
        this.endPage = Math.min(startPage+pageSize-1,totalPage);
    }
    public void setPrev(int startPage,int pageSize){
        this.prev = startPage>pageSize;
    }
    public void setNext(int endPage,int totalPage){
        this.next=false;
        if(endPage<totalPage){
            this.next = true;
        }
    }
    public void setOffSet(int currentPage, int recordSize){
        this.offset = (currentPage-1)*recordSize;
    }

}
