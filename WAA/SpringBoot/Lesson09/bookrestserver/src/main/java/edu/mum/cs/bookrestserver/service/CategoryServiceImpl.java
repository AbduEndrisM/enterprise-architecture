package edu.mum.cs.bookrestserver.service;

import edu.mum.cs.bookrestserver.domain.Category;
import edu.mum.cs.bookrestserver.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private ApplicationRepository applicationRepository;

     public CategoryServiceImpl() {
     }

    @Override
    public List<Category> getAllCategories() {
        return applicationRepository.getCategories();
    }
    
    @Override
    public Category getCategory(int id) {
        for (Category category : applicationRepository.getCategories()) {
            if (id == category.getId()) {
                return category;
            }
        }
        return null;
    }

    @Override
    public Category getCategoryByName(String name) {
        for (Category category : applicationRepository.getCategories()) {
            if (name.equals( category.getName()) ) {
                return category;
            }
        }
        return null;
    }

     @Override
    public Category save(Category category) {
    	 category.setId(getNextId());
    	 applicationRepository.getCategories().add(category);
        return category;
    }

     
    @Override
    public Category update(Category category) {
        int categoryCount = applicationRepository.getCategories().size();
        for (int i = 0; i < categoryCount; i++) {
            Category savedCategory = applicationRepository.getCategories().get(i);
            if (savedCategory.getId() == category.getId()) {
            	applicationRepository.getCategories().set(i, category);
                return category;
            }
        }
        return category;
    }
    

    public int getNextId() {
        int id = 0;
        for (Category category : applicationRepository.getCategories()) {
            int categoryId = category.getId();
            if (categoryId > id) {
                id = categoryId;
            }
        }
        return id + 1;
    }
}
