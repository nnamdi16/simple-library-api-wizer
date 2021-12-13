package com.nnamdi.library.model.request;

public class CreateCategoryDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CreateCategoryDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
