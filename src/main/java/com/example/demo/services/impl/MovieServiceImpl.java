package com.example.demo.services.impl;

import com.example.demo.client.WebAPIIFeignClient;
import com.example.demo.client.response.apii_nguonc_movie.MovieApiiResponse;
import com.example.demo.domain.*;
import com.example.demo.repositories.*;
import com.example.demo.services.MovieService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {
    private final WebAPIIFeignClient webAPIIFeignClient;
    private final MovieRepo movieRepo;
    private final ActorRepo actorRepo;
    private final CategoryRepo categoryRepo;
    private final CountryRepo countryRepo;
    private final DirectorRepo directorRepo;

    //
    private Set<Actor> actorList;
    private Set<Category> categoryList;
    private Set<Country> countryList;
    private Set<Director> directorList;

    public MovieServiceImpl(WebAPIIFeignClient webAPIIFeignClient, MovieRepo movieRepo, ActorRepo actorRepo, CategoryRepo categoryRepo, CountryRepo countryRepo, DirectorRepo directorRepo) {
        this.webAPIIFeignClient = webAPIIFeignClient;
        this.movieRepo = movieRepo;
        this.actorRepo = actorRepo;
        this.categoryRepo = categoryRepo;
        this.countryRepo = countryRepo;
        this.directorRepo = directorRepo;
    }

    @Transactional
    @Override
    public void create(List<String> slugs) {
        this.getDataRelate();
        List<Movie> movieListInsert = new ArrayList<>();
        if (!slugs.isEmpty()) {
            slugs.forEach(slug -> {
                MovieApiiResponse movieApiiResponse = this.webAPIIFeignClient.getMovieFromApii(slug);
                System.out.printf(movieApiiResponse.toString());
            });
        }
    }

    // prepare data for movie insert
    private void getDataRelate() {
        this.actorList = new HashSet<>(Optional.of(this.actorRepo.findAll()).orElse(new ArrayList<>()));
        this.categoryList = new HashSet<>(Optional.of(this.categoryRepo.findAll()).orElse(new ArrayList<>()));
        this.countryList = new HashSet<>(Optional.of(this.countryRepo.findAll()).orElse(new ArrayList<>()));
        this.directorList = new HashSet<>(Optional.of(this.directorRepo.findAll()).orElse(new ArrayList<>()));
    }

//    private Movie hanldeMovieResponseToMovie(MovieApiiResponse movieApiiResponse) {
//
//    }
}
