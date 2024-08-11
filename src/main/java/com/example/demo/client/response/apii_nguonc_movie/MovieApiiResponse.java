package com.example.demo.client.response.apii_nguonc_movie;

import java.util.List;

public class MovieApiiResponse {
    private Boolean status;
    private String msg;
//    private MovieResponse movie;
//    private List<EpisodeResponse> episodes;
    public MovieApiiResponse() {
    }

    public MovieApiiResponse(Boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    //    public MovieApiiResponse(Boolean status, String msg, MovieResponse movie, List<EpisodeResponse> episodes) {
//        this.status = status;
//        this.msg = msg;
//        this.movie = movie;
//        this.episodes = episodes;
//    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

//    public MovieResponse getMovie() {
//        return movie;
//    }
//
//    public void setMovie(MovieResponse movie) {
//        this.movie = movie;
//    }
//
//    public List<EpisodeResponse> getEpisodes() {
//        return episodes;
//    }
//
//    public void setEpisodes(List<EpisodeResponse> episodes) {
//        this.episodes = episodes;
//    }
}
