package edu.mum.cs.springbootthymeleaf.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import edu.mum.cs.springbootthymeleaf.domain.Address;
import edu.mum.cs.springbootthymeleaf.domain.Employee;
import edu.mum.cs.springbootthymeleaf.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class StandardExpressionController {

	@GetMapping("/simpleExpression")
	public String displaySimpleExpressions(Model model) {

		Address addr = new Address("1000 N 4th St", "Fairfield", "IA", "52556");
		Employee e = new Employee(1L, "Black", "Friday", LocalDate.of(2018, 10, 01), 100, addr);

		model.addAttribute("emp", e);

		return "SimpleExpression";
	}

	@GetMapping("/conditionalExpression")
	public String displayConditionalExpressions(Model model) {
		Employee e = new Employee(1L, "Black", "Friday", LocalDate.of(2018, 10, 01), 100, null);
		model.addAttribute("emp", e);

		Address addr = new Address("1000 N 4th St", "Fairfield", "IA", "52556");
		Employee e2 = new Employee(1L, "Black", "Friday", LocalDate.of(2018, 10, 01), 100, addr);
		model.addAttribute("emp2", e2);

		model.addAttribute("gender", "F");
		return "ConditionalExpression";
	}

	@GetMapping("/iteration")
	public String displayIteration(Model model) {
		List<Product> prods = Arrays.asList(new Product("Tissue", 1.53, true), new Product("iPad", 100.53, true),
				new Product("Keyboard", 50.88, false));
		model.addAttribute("prods", prods);
		return "IterationExpression";
	}
}
