package com.nnamdi.library.repository;

import com.nnamdi.library.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Boolean existsBookByTitle(String title);
    @Query("SELECT u from Book u  where u.ratings=5")
    List<Book> findFavouriteBooks();
}