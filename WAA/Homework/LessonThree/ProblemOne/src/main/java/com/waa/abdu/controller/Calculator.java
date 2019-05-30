package com.waa.abdu.controller;

import com.waa.abdu.service.Calculate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculator {
    @RequestMapping("/")
    public ModelAndView calculator(@RequestParam("num1") int x, @RequestParam("num2") int y) {
        Calculate c = new Calculate();
        int z = c.sum(x,y);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("result.jsp");
        mv.addObject("answer", z);

        System.out.println("Yes!!");

        return mv;
    }


}
