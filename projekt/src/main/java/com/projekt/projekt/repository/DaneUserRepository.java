package com.projekt.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekt.projekt.model.DaneUser;

// Interfejs rozszerzający JpaRepository dostarcza podstawowe operacje CRUD dla encji DaneUser
public interface DaneUserRepository extends JpaRepository<DaneUser, Integer> {
    // Metoda zadeklarowana w interfejsie, umożliwiająca znalezienie obiektu DaneUser na podstawie danego identyfikatora
    DaneUser findByDaneUserId(Integer daneUserId);
}
