package com.projekt.projekt.repository;

import com.projekt.projekt.model.Zdjecie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZdjecieRepository extends JpaRepository<Zdjecie, Long> {
}
