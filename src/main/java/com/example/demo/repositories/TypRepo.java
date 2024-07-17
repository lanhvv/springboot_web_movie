package com.example.demo.repositories;

import com.example.demo.domain.Typ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypRepo extends JpaRepository<Typ, Long> {
}
