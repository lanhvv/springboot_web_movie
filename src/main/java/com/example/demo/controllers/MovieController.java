package com.example.demo.controllers;

import com.example.demo.services.MovieService;
import com.example.demo.utils.PathUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathUtils.ROOT + "/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /*
    * note
    * rest api get body is array, then site request also require array */
    @PostMapping("/create")
    public ResponseEntity<Object> create() {
//        this.movieService.create(slugs);
        return null;
    }
}
