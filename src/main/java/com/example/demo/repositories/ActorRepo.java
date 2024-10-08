package com.example.demo.repositories;

import com.example.demo.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActorRepo extends JpaRepository<Actor, Long> {
    Optional<Actor> findByName(String name);
}
