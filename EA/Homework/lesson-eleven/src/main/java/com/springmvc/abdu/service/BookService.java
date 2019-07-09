package com.springmvc.abdu.service;


import com.springmvc.abdu.domain.Book;
import com.springmvc.abdu.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void save(Book book) {
        bookRepository.save(book);
    }

    public Book getBook(Integer id) {
        return  bookRepository.findById(id).get();
    }

    public List<Book> allBooks(){
        return bookRepository.findAll();
    }

    public void deleteBook(Integer id){
        bookRepository.deleteById(id);
    }


}