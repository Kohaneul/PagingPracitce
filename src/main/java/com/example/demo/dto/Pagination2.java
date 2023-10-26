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
public class Pagination2 implements Pagination{
    private int recordSize = 10;    //한 페이지당 데이터 갯수
    private int pageSize = 5;       //페이지 사이즈
    private int totalCount;         //전체 데이터 갯수
    private int currentPage;        //현재 페이지
    private int startPage = 1;      //시작 페이지
    private int endPage;            //한 블럭 안에 끝 페이지
    private int totalPage;          //전체 페이지
    private boolean prev = false;   //이전 페이지 여부
    private boolean next = false;   //다음 페이지 여부
    private int offset;     //얼만큼 끊어서 가져올것인가

    public Pagination2(final int currentPage,final int totalCount){
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        setTotalPage(totalCount);
        setStartPage(this.startPage,currentPage,pageSize);
        setEndPage(this.startPage,this.pageSize,this.totalPage);
        setPrev(this.startPage,this.pageSize);
        setNext(endPage,totalPage);
        setOffSet(currentPage,recordSize);
    }
    public void setTotalPage(int totalCount){
        this.totalPage = (int)Math.ceil(totalCount*1.0/recordSize);
    }
    public void setStartPage(final int startPage,int currentPage,int pageSize){
        //10페이지
        this.startPage = startPage + (((currentPage-startPage) / pageSize) * pageSize);

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
