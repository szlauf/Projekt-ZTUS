package com.projekt.projekt.repository;

import com.projekt.projekt.model.Marka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkaRepository extends JpaRepository<Marka, Integer> {
    // You can add custom query methods if needed
}
