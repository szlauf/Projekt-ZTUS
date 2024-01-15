package com.projekt.projekt.repository;

import com.projekt.projekt.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartsRepository extends JpaRepository<Part, Long> {
    // You can add custom query methods if needed
}
