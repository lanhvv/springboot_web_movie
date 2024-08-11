package com.example.demo.dto.mapper;

import com.example.demo.client.response.apii_nguonc_movie.MovieResponse;
import com.example.demo.client.response.apii_nguonc_movie.TypeTextResponse;
import com.example.demo.domain.*;
import org.mapstruct.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ToDoMovieMapper {
    @Mapping(target = "actors", expression = "java(toActor(movieResponse.getActor(), actorListDB))")
    @Mapping(target = "directors", expression = "java(toDirector(movieResponse.getDirector(), directorListDB))")
    @Mapping(target = "countries", expression = "java(toCountry(movieResponse.getCountry(), countryListDB))")
    @Mapping(target = "categories", expression = "java(toCategory(movieResponse.getCategory(), categoryListDB))")
    @Mapping(target = "typeMovie", source = "movieResponse.type")
    Movie MovieResponseAiiToMovie(MovieResponse movieResponse, Set<Actor> actorListDB, Set<Director> directorListDB, Set<Country> countryListDB, Set<Category> categoryListDB);

    @Named("toActor")
    default Set<Actor> toActor(List<String> actorListResponse, Set<Actor> actorListDB) {
        actorListResponse.stream()
                .filter(actorRs -> !actorListDB.stream().filter(actorDB -> !actorDB.getName().equals(actorRs)).toList().isEmpty())
                .forEach(actorRs -> actorListDB.add(new Actor(actorRs)));
        return new HashSet<>(actorListDB);
    }

    @Named("toDirector")
    default Set<Director> toDirector(List<String> directorListResponse, Set<Director> directorListDB) {
        directorListResponse.stream()
                .filter(directorRs -> !directorListDB.stream().filter(directorDB -> !directorDB.getName().equals(directorRs)).toList().isEmpty())
                .forEach(directorRs -> directorListDB.add(new Director(directorRs)));
        return new HashSet<>(directorListDB);
    }

    @Named("toCountry")
    default Set<Country> toCountry(List<TypeTextResponse> countryListResponse, Set<Country> countryListDB) {
        countryListResponse.stream()
                .filter(countryRs -> !countryListDB.stream().filter(countryDB -> !countryDB.getName().equals(countryRs.getName())).toList().isEmpty())
                .forEach(countryRs -> countryListDB.add(new Country(countryRs.getName())));
        return new HashSet<>(countryListDB);
    }


    @Named("toCategory")
    default Set<Category> toCategory(List<TypeTextResponse> countryListResponse, Set<Category> categoryListDB) {
        countryListResponse.stream()
                .filter(categoryRs -> !categoryListDB.stream().filter(categoryDB -> !categoryDB.getSlug().equals(categoryRs.getSlug())).toList().isEmpty())
                .forEach(categoryRs -> categoryListDB.add(new Category(categoryRs.getSlug(), categoryRs.getName())));
        return new HashSet<>(categoryListDB);
    }
}
