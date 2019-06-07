package edu.mum.cs.springbootthymeleaflayout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	@GetMapping("/")
	public String greet(Model model) {
		model.addAttribute("firstName", "Josh");
		return "index";
	}

}
