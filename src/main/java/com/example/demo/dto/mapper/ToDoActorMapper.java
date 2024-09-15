package com.example.demo.dto.mapper;

import com.example.demo.domain.Actor;
import com.example.demo.dto.response.ActorDTPRS;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ToDoActorMapper {
    List<ActorDTPRS> toDoEntityToDTO(List<Actor> actorList);
}
