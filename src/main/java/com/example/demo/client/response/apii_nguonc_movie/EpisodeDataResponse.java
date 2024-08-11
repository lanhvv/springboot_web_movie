package com.example.demo.client.response.apii_nguonc_movie;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EpisodeDataResponse {
    private String name;
    private String slug;
    private String filename;
    @JsonProperty("link_embed")
    private String linkEmbed;
    @JsonProperty("link_m3u8")
    private String linkM3u8;

    public EpisodeDataResponse() {
    }

    public EpisodeDataResponse(String name, String slug, String filename, String linkEmbed, String linkM3u8) {
        this.name = name;
        this.slug = slug;
        this.filename = filename;
        this.linkEmbed = linkEmbed;
        this.linkM3u8 = linkM3u8;
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
}
