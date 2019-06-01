package com.waa.abdu.controller;

import com.waa.abdu.service.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController  {



    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/calculator")
    public ModelAndView calculator(@RequestParam("num1") int x, @RequestParam("num2") int y) {

        Calculator calculator = new Calculator();
       int answer =  calculator.sum(x, y);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("result");
        mv.addObject("answer", answer);

        System.out.println("Yes!!");

        return mv;
    }

}


