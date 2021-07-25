package com.example.library.book;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;
    private String author;
    private String title;
    private LocalDate yop;
    @Transient
    private Integer age;

    public Book() {
    }

    public Book(Long id,
                String author,
                String title,
                LocalDate yop) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.yop = yop;
    }

    public Book(String author,
                String title,
                LocalDate yop) {
        this.author = author;
        this.title = title;
        this.yop = yop;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getYop() {
        return yop;
    }

    public void setYop(LocalDate yop) {
        this.yop = yop;
    }

    public Integer getAge() {
        return Period.between(this.yop, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", yop=" + yop +
                ", age=" + age +
                '}';
    }
}
