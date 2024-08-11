package com.example.demo.client;

import com.example.demo.client.response.apii_nguonc_movie.MovieApiiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "WebAPIIFeignClient", url = "${url.web_apii}")
public interface WebAPIIFeignClient {
    @GetMapping(path = "/phim/{slug}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    MovieApiiResponse getMovieFromApii(@PathVariable String slug);
}
