package com.example.app.model.builders;

import com.example.app.mongo.documents.Book;

import java.time.LocalDate;

public class BookBuilder {

    private String id;
    private String title;
    private String author;
    private int numPages;
    private LocalDate releaseDate;

    public BookBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder setNumPages(int numPages) {
        this.numPages = numPages;
        return this;
    }

    public BookBuilder setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Book createBook() {
        return new Book(id, title, author, numPages, releaseDate);
    }
}