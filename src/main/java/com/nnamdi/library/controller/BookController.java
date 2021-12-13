package com.nnamdi.library.controller;

import com.nnamdi.library.exceptions.DuplicateException;
import com.nnamdi.library.model.Book;
import com.nnamdi.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public ResponseEntity<?> addBook(@Valid @RequestBody Book book) throws DuplicateException {

        Book saveBook = bookService.addBook(book);
        return  new ResponseEntity<>(saveBook, HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> findAllBooks()  {
        List<Book> books = bookService.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }


    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book category) throws DuplicateException {
        Book updateBook = bookService.updateBooks(id, category);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @PutMapping("/category/book/{id}")
    public ResponseEntity<Book> assignBookCategory(@PathVariable("id") Long id, @RequestBody Book book) throws DuplicateException {
        Book updateBook = bookService.addBookToCategory(id, book);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Long id)  {
        Book book = bookService.deleteBook(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("favorite/books")
    public ResponseEntity<List<Book>> findFavoriteBooks()  {
       List<Book>  books = bookService.findFavouriteBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }


}
