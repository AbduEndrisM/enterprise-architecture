package com.springmvc.abdu.controller;

import com.springmvc.abdu.domain.Book;
import com.springmvc.abdu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "/book"})
public class BookController {

    @Autowired
    BookService bookService;
    @GetMapping("/")
    public String addBook(@ModelAttribute("book") Book book) {
        return "addBook";
    }


    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book book, BindingResult result) {

        if (result.hasErrors())
            return "addBook";
        bookService.save(book);

        return "redirect:/book/bookList";
    }

    @GetMapping("/bookList")
    public String bookDetail(Model model) {
        model.addAttribute("books", bookService.allBooks());
        return "bookList";
    }


}
