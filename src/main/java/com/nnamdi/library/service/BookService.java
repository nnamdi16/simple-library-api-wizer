package com.nnamdi.library.service;

import com.nnamdi.library.exceptions.DuplicateException;
import com.nnamdi.library.exceptions.NotFoundException;
import com.nnamdi.library.model.Book;
import com.nnamdi.library.model.Category;

import java.util.List;
import java.util.Set;

public interface BookService {
    Book addBook(Book book) throws DuplicateException;
    Book findBookById(Long id) throws NotFoundException;
    List<Book> findAllBooks();
    Book updateBooks(Long id, Book book) throws NotFoundException;
    Book addBookToCategory(Long bookId, Set<Category> categories);
    Set<Category> checkIfBookCategoryExists(Set<Category> bookCategory) throws NotFoundException;
    Book deleteBook(Long bookId);
    List<Book> findFavouriteBooks();

}
