package com.example.app.services;

import com.example.app.model.builders.BookBuilder;
import com.example.app.mongo.documents.Book;
import com.example.app.mongo.repositories.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private SimpMessagingTemplate template;

    @InjectMocks
    private BookService bookService;


    @Test
    public void shouldCreateIdForDocument() throws JsonProcessingException {
        Book newBook = new BookBuilder()
                .setTitle("Test Title")
                .setAuthor("Test Author")
                .setNumPages(100)
                .setReleaseDate(LocalDate.of(2020, 12,10))
                .createBook();

        bookService.insertBook(newBook);
        verify(bookRepository, times(1)).save(any());
        verify(template, times(1)).convertAndSend(any(), anyString());
    }


}