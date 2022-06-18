package com.example.corespringsecurity.controller.user;

import com.example.corespringsecurity.domain.entity.Account;
import com.example.corespringsecurity.domain.dto.AccountDto;
import com.example.corespringsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by sskim on 2022/06/05
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/mypage")
    public String myPage() throws Exception {
        return "user/mypage";
    }

    @GetMapping("/users")
    public String createUser() {
        return "user/login/register";
    }

    @PostMapping("/users")
    public String createUser(AccountDto accountDto) {

        ModelMapper modelMapper = new ModelMapper();
        Account account = modelMapper.map(accountDto, Account.class);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        userService.createUser(account);

        return "redirect:/";
    }
}
