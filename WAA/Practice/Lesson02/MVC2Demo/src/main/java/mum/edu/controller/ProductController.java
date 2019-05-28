package mum.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.domain.Product;
import mum.edu.framework.annotation.AutoWired;
import mum.edu.framework.annotation.RequestMapping;
import mum.edu.framework.annotation.Controller;
import mum.edu.validator.ProductValidator;

@Controller
public class ProductController {

	@AutoWired
	ProductValidator productValidator;

	@RequestMapping(value = { "/", "/product_input" })
	public String inputProduct(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/jsp/ProductForm.jsp";
	}

	@RequestMapping(value = "/product_save")
	public String saveProduct(Product product, HttpServletRequest request, HttpServletResponse response) {
		List<String> errors = productValidator.validate(product);
		if (errors.isEmpty()) {
			// store product in a scope variable for the view
			request.setAttribute("product", product);
			return "/WEB-INF/jsp/ProductDetails.jsp";
		} else {

			// store errors and product in a scope variable for the view
			request.setAttribute("errors", errors);
			request.setAttribute("form", product);
			return "/WEB-INF/jsp/ProductForm.jsp";
		}
	}
}
