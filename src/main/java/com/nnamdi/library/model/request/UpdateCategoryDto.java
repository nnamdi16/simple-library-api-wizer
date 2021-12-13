package com.nnamdi.library.model.request;

public class UpdateCategoryDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UpdateCategoryDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
