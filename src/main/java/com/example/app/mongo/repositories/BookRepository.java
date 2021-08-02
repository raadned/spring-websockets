package com.example.app.mongo.repositories;

import com.example.app.mongo.documents.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByTitle(String title);
    Optional<Book> findById(String id);
}
