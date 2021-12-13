package com.nnamdi.library.service;

import com.nnamdi.library.exceptions.DuplicateException;
import com.nnamdi.library.exceptions.NotFoundException;
import com.nnamdi.library.model.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory(Category category) throws DuplicateException;
    Category findCategoryById(Long id) throws NotFoundException;
    List<Category> findAllCategories();
    Category updateCategory(Long id, Category category) throws NotFoundException;
    Category deleteCategory(Long categoryId);
}
