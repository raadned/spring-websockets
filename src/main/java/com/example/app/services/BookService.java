package com.example.app.services;

import com.example.app.mongo.documents.Book;
import com.example.app.mongo.repositories.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {

    Logger log = LoggerFactory.getLogger(BookService.class);

    @Autowired
    public BookRepository bookRepository;

    @Autowired
    private SimpMessagingTemplate template;

    public void insertBook(Book book) throws JsonProcessingException {
        setMongoDocumentIdFor(book);
        log.info("Saving book {}", book);
        bookRepository.save(book);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(book);
        template.convertAndSend("/topic/updates", json);
        log.info("Saved book {}", book);
    }

    public List<Book> getAllBooks() {
        log.info("Retrieving all books");
        return bookRepository.findAll();
    }

    private void setMongoDocumentIdFor(Book book) {
        String mongoId = book.getTitle().replaceAll("\\s+", "_").toLowerCase();
        book.setId(mongoId);
    }

}
