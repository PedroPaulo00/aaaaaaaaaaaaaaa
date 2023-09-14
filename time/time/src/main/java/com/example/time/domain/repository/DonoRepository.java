package com.example.time.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.time.domain.model.Dono;

public interface DonoRepository extends JpaRepository<Dono, Long> {
    Optional<Dono> findByEmail (String email);
}
