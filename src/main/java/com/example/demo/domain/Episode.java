package com.example.demo.domain;

import jakarta.persistence.*;

@Entity(name = "episode")
@Table(name = "episode")
public class Episode {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String slug;

    private String filename;

    @Column(name = "link_embed")
    private String linkEmbed;

    @Column(name = "link_m3u8")
    private String linkM3u8;

    @ManyToOne()
    private Movie movie;

    public Episode() {
    }

    public Episode(Long id, String name, String slug, String filename, String linkEmbed, String linkM3u8, Movie movie) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.filename = filename;
        this.linkEmbed = linkEmbed;
        this.linkM3u8 = linkM3u8;
        this.movie = movie;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getLinkEmbed() {
        return linkEmbed;
    }

    public void setLinkEmbed(String linkEmbed) {
        this.linkEmbed = linkEmbed;
    }

    public String getLinkM3u8() {
        return linkM3u8;
    }

    public void setLinkM3u8(String linkM3u8) {
        this.linkM3u8 = linkM3u8;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
