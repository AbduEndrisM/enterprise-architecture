package com.waa.abdu.controller;

import com.waa.abdu.domain.MyCalc;
import com.waa.abdu.service.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CalculatorController  {



    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/calcT")
    public String calculatorT(Model model,MyCalc myCalc) {


         Calculator calculator = new Calculator();
        int sum =  calculator.sum(myCalc.getAdd1(), myCalc.getAdd2());
        int product = calculator.product(myCalc.getMult1(), myCalc.getMult2());


        Map< String, Integer > inputValues = new HashMap<String, Integer>();
        inputValues.put("a", myCalc.getAdd1());
        inputValues.put("b", myCalc.getAdd2());
        inputValues.put("x", myCalc.getMult1());
        inputValues.put("y", myCalc.getMult2());

        model.addAttribute("input",inputValues);

//        model.addAttribute("a",myCalc.getAdd1());
//        model.addAttribute("b",myCalc.getAdd2());
//        model.addAttribute("x",myCalc.getMult1());
//        model.addAttribute("x",myCalc.getMult2());

        model.addAttribute("sum",sum);
        model.addAttribute("product", product);

        return "result";
    }

}


