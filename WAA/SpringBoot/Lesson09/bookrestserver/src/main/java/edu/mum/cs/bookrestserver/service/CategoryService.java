package edu.mum.cs.bookrestserver.service;


import edu.mum.cs.bookrestserver.domain.Category;

import java.util.List;

public interface CategoryService {
    
    List<Category> getAllCategories();
    Category getCategory(int id);
    Category save(Category category);
	Category update(Category category);
	public Category getCategoryByName(String name);
}
