package mum.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.domain.Product;
import mum.edu.framework.annotation.AutoWired;
import mum.edu.framework.annotation.RequestMapping;
import mum.edu.validator.Validator;

@mum.edu.framework.annotation.Controller
public class ProductController  {  

@AutoWired	
 Validator productValidator;
	
	@RequestMapping(value={"/","/product_input"})
	public String inputProduct() {
		return "/WEB-INF/jsp/ProductForm.jsp";
	}

	@RequestMapping(value={"/save","/product_save"})
	public String saveProduct(Product product, HttpServletRequest request) {
 //        ProductValidator productValidator = new ProductValidator();
        List<String> errors = productValidator.validate(product);
        if (errors.isEmpty()) {
             // no validation error, execute action method
            // insert code to save product to the database

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
