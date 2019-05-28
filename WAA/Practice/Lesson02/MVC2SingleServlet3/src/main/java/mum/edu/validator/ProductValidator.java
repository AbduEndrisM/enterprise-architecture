package mum.edu.validator;

import java.util.ArrayList;
import java.util.List;

import mum.edu.domain.Product;

public class ProductValidator {
	
	public List<String> validate(Product  product ) {
		List<String> errors = new ArrayList<String>();
		
		String name = product.getName();
		if (name == null || name.trim().isEmpty()) {
			errors.add("Product must have a name");
		}
		Double price = product.getPrice();
		if (price == null) {
			errors.add("Product must have a price");
		} 
		return errors;
	}
}
