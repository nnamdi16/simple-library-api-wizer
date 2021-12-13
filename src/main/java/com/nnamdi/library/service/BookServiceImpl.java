package com.nnamdi.library.service;

import com.nnamdi.library.exceptions.DuplicateException;
import com.nnamdi.library.exceptions.NotFoundException;
import com.nnamdi.library.model.Book;
import com.nnamdi.library.model.Category;
import com.nnamdi.library.repository.BookRepository;
import com.nnamdi.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService
{
    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Book addBook(Book book) throws DuplicateException {
        if (bookRepository.existsBookByTitle(book.getTitle())){
            throw new DuplicateException("Book already exists");
        }
        book.setCategory(null);
        book.setTitle(book.getTitle().toUpperCase());
        Book saveBook = bookRepository.save(book);
        return saveBook;
    }

    @Override
    public Book findBookById(Long id) throws NotFoundException {
        Book book = bookRepository.findById(id).get();
        if (book == null) {
            throw new NotFoundException("Book not found");
        }
        return  book;
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> book = (List<Book>) bookRepository.findAll();
        return book;
    }

    @Override
    public Book updateBooks(Long id, Book updatedBook) throws NotFoundException {
        Book book = bookRepository.findById(id).get();
        if (book == null) {
            throw  new NotFoundException("Book not found");
        }
        book.setTitle((updatedBook.getTitle() == null) ? book.getTitle() : updatedBook.getTitle() );
        book.setDescription((updatedBook.getDescription() == null) ? book.getDescription(): updatedBook.getDescription());
        book.setPages((updatedBook.getPages() == null) ?  book.getPages() : updatedBook.getPages() );
        book.setEdition((updatedBook.getEdition() == null) ? book.getEdition(): updatedBook.getEdition() );
        book.setPublisher((updatedBook.getPublisher() == null) ? book.getPublisher(): updatedBook.getPublisher());
        book.setRatings((updatedBook.getRatings() == null) ? book.getRatings() : updatedBook.getRatings());
        Set<Category> updatedBookCategories = checkIfBookCategoryExists(updatedBook.getCategory());
         if (updatedBook.getCategory() != null && updatedBookCategories != null) {
             book.setCategory(updatedBookCategories);
        }
         bookRepository.save(book);
         return book;
    }

    @Override
    public Book addBookToCategory(Long bookId, Book book) {
        Set<Category> category =  book.getCategory();
        Set<Category> assignedCategories = checkIfBookCategoryExists(category);
        Book existingBook = findBookById(bookId);
        if (assignedCategories != null) {
            existingBook.setCategory(assignedCategories);
        }
        return  updateBooks(existingBook.getBookId(), existingBook);
    }


    @Override
    public Set<Category> checkIfBookCategoryExists(Set<Category> bookCategory) {
        Set<Category> categories = new HashSet<>();
        for (Category category: bookCategory){
            Category existingCategory = categoryRepository.findById(category.getCategoryId()).get();
            System.out.println(existingCategory.getName());
            if (existingCategory == null){
                throw  new NotFoundException("Category " + category.getName() + " does not exist");
            }
            categories.add(existingCategory);
        }
        return  categories;
    }

    @Override
    public Book deleteBook(Long bookId) {
        Book book = findBookById(bookId);
        if (book != null) {
            bookRepository.delete(book);
        }
        return book;
    }

    @Override
    public List<Book> findFavouriteBooks() {
        List<Book> book = bookRepository.findFavouriteBooks();
        return book;
    }
}
