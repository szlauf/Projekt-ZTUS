package com.projekt.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekt.projekt.model.Model;

// Interfejs ModelRepository rozszerza interfejs JpaRepository, który umożliwia operacje na danych związanych z encją Model.
public interface ModelRepository extends JpaRepository<Model, Integer> {

    // Deklaracja metody findByNazwaModeluAndGeneracja, która będzie używana do wyszukiwania obiektu Model na podstawie nazwy modelu i generacji.
    // Metoda ta jest automatycznie implementowana przez Spring Data JPA na podstawie nazewnictwa.
    Model findByNazwaModeluAndGeneracja(String nazwaModelu, String generacja);
}
