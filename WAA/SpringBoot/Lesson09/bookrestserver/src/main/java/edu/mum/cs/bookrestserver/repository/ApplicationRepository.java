package edu.mum.cs.bookrestserver.repository;


import edu.mum.cs.bookrestserver.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ApplicationRepository {

	private List<Category> categories;

	public ApplicationRepository() {
		categories = new ArrayList<Category>();
		categories.add(new Category(1, "Computing"));
		categories.add(new Category(2, "Travel"));
		categories.add(new Category(3, "Health"));

	}

	public List<Category> getCategories() {
		return categories;
	}

}
