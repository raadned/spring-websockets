package com.example.app.mongo.documents;

import com.example.app.model.builders.BookBuilder;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

    @Id
    private String id;

    private String title;
    private String author;
    private int numPages;
    private LocalDate releaseDate;

    public Book() {}

    public Book(String title, String author, int numPages, LocalDate releaseDate) {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
        this.releaseDate = releaseDate;
    }

    public Book(String id, String title, String author, int numPages, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.numPages = numPages;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numPages == book.numPages && Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(releaseDate, book.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, numPages, releaseDate);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numPages=" + numPages +
                ", releaseDate=" + releaseDate +
                '}';
    }

    public static Book deepClone(Book book) {
        return new BookBuilder()
                .setId(book.getId())
                .setAuthor(book.getAuthor())
                .setNumPages(book.getNumPages())
                .setTitle(book.getTitle())
                .setReleaseDate(book.getReleaseDate())
                .createBook();
    }

}
