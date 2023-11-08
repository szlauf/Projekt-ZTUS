package com.projekt.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekt.projekt.model.DaneUser;


public interface DaneUserRepository extends JpaRepository<DaneUser, Integer> {
    DaneUser findByDaneUserId(Integer daneUserId);
}
