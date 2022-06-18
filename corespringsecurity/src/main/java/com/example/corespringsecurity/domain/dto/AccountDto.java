package com.example.corespringsecurity.domain.dto;

import lombok.Data;

/**
 * Created by sskim on 2022/06/05
 */
@Data
public class AccountDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Integer age;
    private String role;
}
