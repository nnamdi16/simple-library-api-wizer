package com.nnamdi.library.repository;

import com.nnamdi.library.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
    Boolean existsCategoryByName(String name);
}
