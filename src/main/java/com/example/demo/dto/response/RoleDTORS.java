package com.example.demo.dto.response;

public class RoleDTORS {
    private String slug;

    private String name;

    public RoleDTORS(String slug, String name) {
        this.slug = slug;
        this.name = name;
    }

    public RoleDTORS() {
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
