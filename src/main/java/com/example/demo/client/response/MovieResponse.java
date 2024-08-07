package com.example.demo.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieResponse {
    private String name;
    private String slug;
    @JsonProperty("origin_name")
    private String originName;
    private String content;
    @JsonProperty("thumb_url")
    private String thumbUrl;
    @JsonProperty("poster_url")
    private String posterUrl;
    private String time;
    @JsonProperty("episode_current")
    private String episodeCurrent;
    @JsonProperty("episode_total")
    private String episodeTotal;
    private String lang;
    private String year;
    private List<String> actor;
    private List<String> director;
    private List<CategoryResponse> category;
    private List<EpisodeResponse> episodes;

    public MovieResponse() {
    }

    public MovieResponse(String name, String slug, String originName, String content, String thumbUrl, String posterUrl, String time, String episodeCurrent, String episodeTotal, String lang, String year, List<String> actor, List<String> director, List<CategoryResponse> category, List<EpisodeResponse> episodes) {
        this.name = name;
        this.slug = slug;
        this.originName = originName;
        this.content = content;
        this.thumbUrl = thumbUrl;
        this.posterUrl = posterUrl;
        this.time = time;
        this.episodeCurrent = episodeCurrent;
        this.episodeTotal = episodeTotal;
        this.lang = lang;
        this.year = year;
        this.actor = actor;
        this.director = director;
        this.category = category;
        this.episodes = episodes;
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

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEpisodeCurrent() {
        return episodeCurrent;
    }

    public void setEpisodeCurrent(String episodeCurrent) {
        this.episodeCurrent = episodeCurrent;
    }

    public String getEpisodeTotal() {
        return episodeTotal;
    }

    public void setEpisodeTotal(String episodeTotal) {
        this.episodeTotal = episodeTotal;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getActor() {
        return actor;
    }

    public void setActor(List<String> actor) {
        this.actor = actor;
    }

    public List<String> getDirector() {
        return director;
    }

    public void setDirector(List<String> director) {
        this.director = director;
    }

    public List<CategoryResponse> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryResponse> category) {
        this.category = category;
    }

    public List<EpisodeResponse> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<EpisodeResponse> episodes) {
        this.episodes = episodes;
    }
}
