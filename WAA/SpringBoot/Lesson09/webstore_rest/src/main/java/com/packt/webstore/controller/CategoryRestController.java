package com.packt.webstore.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.packt.webstore.domain.Category;

@RestController
@RequestMapping("/category")
public class CategoryRestController {

	@RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Category getCategoryInJSON(@PathVariable String name) {
		Category category = new Category(1, name);
		category.setDescription("This is " + name + " Category!");

		return category;
	}

	@RequestMapping(value = "/{name}.xml", method = RequestMethod.GET, produces = "application/xml")
	public @ResponseBody Category getCategoryInXML(@PathVariable String name) {
		Category category = new Category(1, name);
		category.setDescription("This is " + name + " Category!");
		return category;
	}

	@RequestMapping(value = "/xml/{name}", method = RequestMethod.GET)
	public @ResponseBody Category getEmployeeInXML(@PathVariable String name) {
		Category category = new Category(1, name);
		category.setDescription("This is " + name + " Category!");
		return category;
	}

}
