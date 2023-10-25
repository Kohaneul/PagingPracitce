package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int rownum; //rownum
    private int name;   //이름
    private int id;     //pk값
    private String loginId; //로그인 아이디
}
