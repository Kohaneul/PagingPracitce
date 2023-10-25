package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDTO {
    private int page;
    private int pageSize = 5;
    private int recordSize=10;
    private String keyword;

    public SearchDTO(){
        this.page=1;
    }
    public int getOffSet(){
        return (page-1)*recordSize;
    }

}
