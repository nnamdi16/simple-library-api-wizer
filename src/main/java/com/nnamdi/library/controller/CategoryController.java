package com.nnamdi.library.controller;

import com.nnamdi.library.exceptions.DuplicateException;
import com.nnamdi.library.model.Category;
import com.nnamdi.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category) throws DuplicateException {
       Category saveCategory = categoryService.addCategory(category);
       return new ResponseEntity<>(saveCategory, HttpStatus.CREATED);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> findAllCategories()  {
        List<Category> categories = categoryService.findAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody Category category) throws DuplicateException {
        Category updateCategory = categoryService.updateCategory(id, category);
        return new ResponseEntity<>(updateCategory, HttpStatus.OK);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") Long id)  {
        Category category = categoryService.deleteCategory(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

}
