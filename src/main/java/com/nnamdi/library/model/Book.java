package com.nnamdi.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book extends AuditModel {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "pages", nullable = false)
    private Integer pages;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "edition", nullable = false)
    private String edition;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "ratings", nullable = false, columnDefinition = "integer default'0'")
    private Integer ratings;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_category",
            joinColumns = {
                    @JoinColumn(name ="book_id" )
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "category_id")
            }
    )
    @JsonIgnoreProperties("books")
    private Set<Category> category = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_authors",
            joinColumns = {
                    @JoinColumn(name ="book_id" )
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    @JsonIgnoreProperties("books")
    private Set<Author> authors = new HashSet<>();

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Book( String title, Integer pages, String description, String edition, String publisher, Integer ratings, Set<Category> category, Set<Author> authors) {
        this.title = title;
        this.pages = pages;
        this.description = description;
        this.edition = edition;
        this.publisher = publisher;
        this.ratings = ratings;
        this.category = category;
        this.authors = authors;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getRatings() {
        return ratings;
    }

    public void setRatings(Integer ratings) {
        this.ratings = ratings;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
