package com.projekt.projekt.repository;

import com.projekt.projekt.model.Model;
import com.projekt.projekt.model.Part;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PartsRepository extends JpaRepository<Part, Long> {
    List<Part> findByModelAndCarProductionYear(Model model, Integer carProductionYear);
}
