package com.example.corespringsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by sskim on 2022/06/12
 */
@Slf4j
@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String home() throws Exception {
        return "home";
    }

}
