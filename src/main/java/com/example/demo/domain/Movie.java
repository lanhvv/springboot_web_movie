package com.example.demo.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "movie")
@Table(name = "movie")
public class Movie extends CommonTable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String slug;

    private String thumbURL;

    private String posterURL;

    private String time;

    private String episodeCurrent;

    private String episodeTotal;

    private String lang;

    private String year;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String statusMovie;

    @ManyToMany
    @JoinTable(
            name = "category_movie",
            joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")}
    )
    private Set<Category> categories;

    private String typeMovie;

    @ManyToMany
    @JoinTable(
            name = "country_movie",
            joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "country_id", referencedColumnName = "id")}
    )
    private Set<Country> countries;

    @ManyToMany
    @JoinTable(
            name = "actor_movie",
            joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id", referencedColumnName = "id")}
    )
    private Set<Actor> actors;

    @ManyToMany
    @JoinTable(
            name = "director_movie",
            joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "director_id", referencedColumnName = "id")}
    )
    private Set<Director> directors;

    @ManyToMany
    @JoinTable(
            name = "user_movie",
            joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
    )
    private Set<User> users;

    // error Episode_.Movie dont use
    @OneToMany(mappedBy = "movie")
    private Set<Episode> episodes;

    public Movie() {
    }

    public Movie(Long id, String name, String slug, String thumbURL, String posterURL, String time, String episodeCurrent, String episodeTotal, String lang, String year, Date date, String statusMovie, Set<Category> categories, String typeMovie, Set<Country> countries, Set<Actor> actors, Set<Director> directors, Set<User> users, Set<Episode> episodes) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.thumbURL = thumbURL;
        this.posterURL = posterURL;
        this.time = time;
        this.episodeCurrent = episodeCurrent;
        this.episodeTotal = episodeTotal;
        this.lang = lang;
        this.year = year;
        this.date = date;
        this.statusMovie = statusMovie;
        this.categories = categories;
        this.typeMovie = typeMovie;
        this.countries = countries;
        this.actors = actors;
        this.directors = directors;
        this.users = users;
        this.episodes = episodes;
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

    public String getThumbURL() {
        return thumbURL;
    }

    public void setThumbURL(String thumbURL) {
        this.thumbURL = thumbURL;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatusMovie() {
        return statusMovie;
    }

    public void setStatusMovie(String statusMovie) {
        this.statusMovie = statusMovie;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getTypeMovie() {
        return typeMovie;
    }

    public void setTypeMovie(String typeMovie) {
        this.typeMovie = typeMovie;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<Episode> episodes) {
        this.episodes = episodes;
    }
}
