package com.example.app.services;

import com.example.app.mongo.documents.Book;
import com.example.app.mongo.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {

    Logger log = LoggerFactory.getLogger(BookService.class);

    @Autowired
    public BookRepository bookRepository;

    public void insertBook(Book book) {
        log.info("Saving book {}", book);
        book.setId(book.getTitle().replaceAll("\\s+", "_").toLowerCase());
        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        log.info("Retrieving all books");
        return bookRepository.findAll();
    }

}
