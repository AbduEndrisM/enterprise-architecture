package mum.edu.validator;

import java.util.List;

import mum.edu.domain.Product;

public interface  Validator  {
	
	public List<String> validate(Object  domainObject ) ;
}
