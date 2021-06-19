package com.example.app.controllers;

import com.example.app.mongo.documents.Book;
import com.example.app.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class BookController {

    Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        log.info("Retrieving all books");
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public Book postBook(@RequestBody Book book) {
        log.info("Saving book {}", book);
        bookService.insertBook(book);
        return book;
    }

}
