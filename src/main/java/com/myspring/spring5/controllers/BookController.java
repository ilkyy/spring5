package com.myspring.spring5.controllers;

import com.myspring.spring5.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(path = "/books")
    public String getAllBooks(Model model){

        model.addAttribute("books",bookRepository.findAll());
        return "bookView";
    }
}
