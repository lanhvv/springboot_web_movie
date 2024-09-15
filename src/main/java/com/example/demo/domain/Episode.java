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

    private Long timePost;

    private Integer location;

    @ManyToOne()
    private Movie movie;

    public Episode() {
    }

    public Episode(String name, String slug, String filename, String linkEmbed, String linkM3u8, Long timePost, Integer location, Movie movie) {
        this.name = name;
        this.slug = slug;
        this.filename = filename;
        this.linkEmbed = linkEmbed;
        this.linkM3u8 = linkM3u8;
        this.timePost = timePost;
        this.location = location;
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getTimePost() {
        return timePost;
    }

    public void setTimePost(Long timePost) {
        this.timePost = timePost;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
