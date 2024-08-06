package com.example.demo.controllers;

import com.example.demo.utils.PathUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PathUtils.ROOT + "/movie")
public class MovieController {
    @PostMapping("/create")
    public ResponseEntity<Object> create() {
        return null;
    }
}
