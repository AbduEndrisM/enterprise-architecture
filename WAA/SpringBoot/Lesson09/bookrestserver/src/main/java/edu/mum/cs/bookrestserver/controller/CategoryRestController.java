package edu.mum.cs.bookrestserver.controller;

import javax.validation.Valid;

import edu.mum.cs.bookrestserver.domain.Category;
import edu.mum.cs.bookrestserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    // @Valid - but NO BindResult! an exception will be thrown...
    @CrossOrigin(origins = {"http://localhost:9080", "http://localhost:9000"}, maxAge = 6000)
    @PostMapping(value = "/api/addCategory", produces = "application/json")
    public Category saveCategory(@Valid @RequestBody Category category) {
        category.setDescription("This is default description...");
        categoryService.save(category);
        return category;
    }

}
