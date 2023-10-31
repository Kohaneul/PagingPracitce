package com.example.demo.entity.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class MemberUpdate {
    @NotNull
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String loginId;
}
