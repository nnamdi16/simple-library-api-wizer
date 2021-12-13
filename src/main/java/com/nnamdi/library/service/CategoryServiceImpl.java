package com.nnamdi.library.service;

import com.nnamdi.library.exceptions.DuplicateException;
import com.nnamdi.library.exceptions.NotFoundException;
import com.nnamdi.library.model.Category;
import com.nnamdi.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    public CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category addCategory(Category category) throws DuplicateException {
        String categoryName = category.getName().toUpperCase();
        if (categoryRepository.existsCategoryByName(categoryName)){
            throw new DuplicateException("Category already exists");
        }
        category.setName(categoryName);
        Category saveCategory = categoryRepository.save(category);
        return saveCategory;
    }

    @Override
    public Category findCategoryById(Long id) throws NotFoundException {
        Category category = categoryRepository.findById(id).get();
        if (category == null) {
            throw new NotFoundException("Category not found");
        }
        return  category;
    }

    @Override
    public List<Category> findAllCategories() {
        List<Category> category = (List<Category>) categoryRepository.findAll();
        return  category;
    }

    @Override
    public Category updateCategory(Long id, Category updatedCategory) {
        Category category = categoryRepository.findById(id).get();
        if (category == null) {
            throw new NotFoundException("Category not found");
        }
        category.setName(updatedCategory.getName().toUpperCase());
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category deleteCategory(Long categoryId) {
        Category category = findCategoryById(categoryId);
        if (category != null) {
            categoryRepository.delete(category);
        }
        return category;
    }


}
