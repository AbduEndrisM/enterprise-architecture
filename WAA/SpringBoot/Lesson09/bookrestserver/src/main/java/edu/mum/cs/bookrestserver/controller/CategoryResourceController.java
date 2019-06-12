package edu.mum.cs.bookrestserver.controller;

import edu.mum.cs.bookrestserver.domain.Category;
import edu.mum.cs.bookrestserver.service.CategoryService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryResourceController {

    private CategoryService categoryService;

    public CategoryResourceController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> retrieveAllCategories() {
        return categoryService.getAllCategories();
    }

    /*@GetMapping("/categories/{id}")
    public Category retrieveCategory(@PathVariable int id){
        return categoryService.getCategory(id);
    }*/

    /**
     * Return data and links
     *
     * @param id
     * @return
     */
    @GetMapping("/categories/{id}")
    public Resource<Category> retrieveCategory(@PathVariable int id) {
        Category category = categoryService.getCategory(id);

        //"all-categories", SERVER_PATH + "/categories"
        //retrieveAllCategories

        Resource<Category> resource = new Resource<>(category);
        ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(
                ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllCategories()
        );

        resource.add(linkTo.withRel("all-categories"));

        return resource;
    }


}
