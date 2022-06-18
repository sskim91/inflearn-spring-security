package com.example.corespringsecurity.repository;

import com.example.corespringsecurity.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sskim on 2022/06/05
 */
public interface UserRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);
}
