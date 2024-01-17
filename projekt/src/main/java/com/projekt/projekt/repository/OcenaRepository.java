package com.projekt.projekt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekt.projekt.model.Ocena;

public interface OcenaRepository extends JpaRepository<Ocena, Integer> {
    List<Ocena> findByIdUser(Integer idUser);
}
