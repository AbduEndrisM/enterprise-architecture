package com.waa.abdu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Welcome {
    @RequestMapping("/")
    public String welcomePage(){
        System.out.println("Abdu E");
        return "welcome";
    }
}
