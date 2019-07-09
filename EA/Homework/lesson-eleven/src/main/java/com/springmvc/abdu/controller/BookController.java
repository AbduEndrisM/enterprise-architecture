package com.springmvc.abdu.controller;

import com.springmvc.abdu.domain.Book;
import com.springmvc.abdu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
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

        return "redirect:/bookList";
    }

    @GetMapping("/bookList")
    public String bookDetail(Model model) {
        model.addAttribute("books", bookService.allBooks());
        return "bookList";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@ModelAttribute Book book, @PathVariable("id") Integer id){
        bookService.deleteBook(id);

        return "bookList";
    }

    @GetMapping("/detail/{id}")
    public String bookDetail(@PathVariable Integer id, Model model){
        model.addAttribute("book", bookService.getBook(id));
        return "bookDetail";
    }



}
