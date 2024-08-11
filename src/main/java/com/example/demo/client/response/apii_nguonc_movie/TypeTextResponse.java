package com.example.demo.client.response.apii_nguonc_movie;

public class TypeTextResponse {
    private String name;
    private String slug;

    public TypeTextResponse() {
    }

    public TypeTextResponse(String name, String slug) {
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
