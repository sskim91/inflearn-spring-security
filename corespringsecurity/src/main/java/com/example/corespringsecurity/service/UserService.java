package com.example.corespringsecurity.service;

import com.example.corespringsecurity.domain.entity.Account;

/**
 * Created by sskim on 2022/06/05
 */
public interface UserService {

    void createUser(Account account);
}
