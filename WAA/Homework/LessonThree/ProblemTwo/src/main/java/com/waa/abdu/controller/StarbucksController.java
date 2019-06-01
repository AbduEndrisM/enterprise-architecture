package com.waa.abdu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class StarbucksController {
    @RequestMapping("/")
    public String homePage(){
        return "index";
    }
    @RequestMapping("advice")
    public String adviveController(Model model ){

        Map< String, String > roastMap = new HashMap<String, String>();

        roastMap.put("Light", "light");
        roastMap.put("Medium", "medium");
        roastMap.put("Dark", "dark");
        model.addAttribute("roasts",roastMap);

        return "advice";
    }

    @RequestMapping("/login")
    public String loginController(){
        return "login";
    }
}
