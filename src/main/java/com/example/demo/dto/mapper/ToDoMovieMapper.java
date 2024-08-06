package com.example.demo.dto.mapper;

import com.example.demo.client.response.MovieResponse;
import com.example.demo.domain.Actor;
import com.example.demo.domain.Movie;
import org.mapstruct.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ToDoMovieMapper {
    @Mapping(target = "actors", expression = "java(checkActor(movieResponse.getActor(), actorListDB))")
    Movie MovieResponseAiiToMovie(MovieResponse movieResponse, Set<Actor> actorListDB);

    @Named("checkActor")
    default Set<Actor> checkActor(List<String> actorListResponse, Set<Actor> actorListDB) {
        actorListResponse.stream()
                .filter(actorRs -> !actorListDB.stream().filter(actorDB -> !actorDB.getName().equals(actorRs)).toList().isEmpty())
                .forEach(actorRs -> actorListDB.add(new Actor(actorRs)));
        return new HashSet<>(actorListDB);
    }
}
