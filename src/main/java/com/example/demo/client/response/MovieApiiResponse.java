package com.example.demo.client.response;

public class MovieApiiResponse {
    private Boolean status;
    private String msg;
    private MovieResponse movie;

    public MovieApiiResponse() {
    }

    public MovieApiiResponse(Boolean status, String msg, MovieResponse movie) {
        this.status = status;
        this.msg = msg;
        this.movie = movie;
    }

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

    public MovieResponse getMovie() {
        return movie;
    }

    public void setMovie(MovieResponse movie) {
        this.movie = movie;
    }
}
