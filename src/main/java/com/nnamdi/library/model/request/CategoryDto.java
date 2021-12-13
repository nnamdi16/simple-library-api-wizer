package com.nnamdi.library.model.request;

import com.nnamdi.library.model.Category;

import java.util.HashSet;
import java.util.Set;

public class CategoryDto {
    private Set<Category> category = new HashSet<>();

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }
}
