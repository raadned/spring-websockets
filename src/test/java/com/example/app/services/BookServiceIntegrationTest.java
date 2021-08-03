package com.example.app.services;

import com.example.app.model.builders.BookBuilder;
import com.example.app.mongo.documents.Book;
import com.example.app.mongo.repositories.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.bwaldvogel.mongo.MongoServer;
import de.bwaldvogel.mongo.backend.memory.MemoryBackend;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookServiceIntegrationTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    private MongoServer server;

    @BeforeEach
    public void setUp() {
        this.server = new MongoServer(new MemoryBackend());
        server.bind("localhost", 27018);
    }

    @AfterEach
    public void tearDown() {
        this.server.shutdown();
    }

    @Test
    public void shouldInsertBookIntoCollection() throws JsonProcessingException {
        Book newBook = new BookBuilder()
                .setTitle("Test Title")
                .setAuthor("Test Author")
                .setNumPages(100)
                .setReleaseDate(LocalDate.of(2020, 12,10))
                .createBook();

        Book expectedBook = Book.deepClone(newBook);
        expectedBook.setId("test_title");

        bookService.insertBook(newBook);
        Optional<Book> result = bookRepository.findById("test_title");
        assertEquals(expectedBook, result.get());
    }
}