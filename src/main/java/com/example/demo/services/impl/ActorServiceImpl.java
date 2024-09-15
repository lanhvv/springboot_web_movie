package com.example.demo.services.impl;

import com.example.demo.config.exception.policy.BusinessLogicException;
import com.example.demo.domain.Actor;
import com.example.demo.dto.mapper.ToDoActorMapper;
import com.example.demo.dto.request.ActorDTORQ;
import com.example.demo.dto.response.ActorDTPRS;
import com.example.demo.repositories.ActorRepo;
import com.example.demo.services.ActorService;
import com.example.demo.utils.CommonHandleCollectionUtils;
import com.example.demo.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ActorServiceImpl implements ActorService {
    private final Logger logger = LoggerFactory.getLogger(ActorServiceImpl.class);
    private final ActorRepo actorRepo;
    private final ToDoActorMapper toDoActorMapper;

    @Override
    public void save(ActorDTORQ in) {

    }

    @Override
    public void delete(ActorDTORQ in) {
        Optional<Actor> actor = this.actorRepo.findByName(in.getName());
        actor.ifPresent(this.actorRepo::delete);
    }

    @Override
    public List<ActorDTPRS> getAll(ActorDTORQ in) {
        boolean flag = false;
        try {
             flag = CommonHandleCollectionUtils.objectToMap(in).entrySet()
                    .stream()
                    .filter(map -> ObjectUtils.isEmpty(map.getValue()))
                    .count() > 0;
        } catch (IllegalAccessException e) {
            throw new BusinessLogicException(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        if (flag) {
            return this.toDoActorMapper.toDoEntityToDTO(this.actorRepo.findAll());
        }
        return List.of();
    }

    @Override
    public List<ActorDTPRS> getList(ActorDTORQ in, Pageable pageable) {
        return List.of();
    }
}
