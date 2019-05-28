package mum.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.domain.Product;
import mum.edu.validator.ProductValidator;

public class ProductController implements Controller {
 
/*	
	@Override
	public String handleRequest(HttpServletRequest request, 
			HttpServletResponse response) {
		return "/WEB-INF/jsp/ProductForm.jsp";
	}
*/
	public String inputProduct() {  
		return "/WEB-INF/jsp/ProductForm.jsp";
	}

	public String saveProduct(Product product, HttpServletRequest request) {
        // validate Product 
        ProductValidator  productValidator = new ProductValidator();
        List<String> errors = productValidator.validate(product);
        if (errors.isEmpty()) {
            // create Product from ProductForm
//            Product product = new Product();
//            product.setName(productForm.getName());
//            product.setDescription(productForm.getDescription());
 //           product.setPrice(Float.parseFloat(productForm.getPrice()));

            // no validation error, execute action method
            // insert code to save product to the database

            // store product in a scope variable for the view
            request.setAttribute("product", product);
            return "/WEB-INF/jsp/ProductDetails.jsp";
        } else {
 
              // store errors and form in a scope variable for the view
            request.setAttribute("errors", errors);
            request.setAttribute("form", product );
            return "/WEB-INF/jsp/ProductForm.jsp";
        }
 	}
}
