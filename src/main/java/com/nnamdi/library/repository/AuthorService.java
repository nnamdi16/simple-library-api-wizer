package com.nnamdi.library.repository;

import com.nnamdi.library.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorService extends CrudRepository<Author, Long> {
}
