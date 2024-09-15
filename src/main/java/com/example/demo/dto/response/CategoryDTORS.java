package com.example.demo.dto.response;

public class CategoryDTORS {
    private String name;
    private String slug;

    public CategoryDTORS() {
    }

    public CategoryDTORS(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
