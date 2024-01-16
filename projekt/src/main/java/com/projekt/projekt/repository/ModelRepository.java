package com.projekt.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekt.projekt.model.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {
    Model findByNazwaModeluAndGeneracja(String nazwaModelu, String generacja);
}
