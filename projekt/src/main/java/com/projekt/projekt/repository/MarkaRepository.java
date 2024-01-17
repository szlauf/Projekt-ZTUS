package com.projekt.projekt.repository;

import com.projekt.projekt.model.Marka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * MarkaRepository jest interfejsem rozszerzającym JpaRepository, który zapewnia podstawowe operacje CRUD
 * (Create, Read, Update, Delete) dla encji Marka w kontekście bazy danych. JpaRepository automatycznie
 * generuje kwerendy SQL, co eliminuje konieczność ręcznego pisanie zapytań.
 *
 * Adnotacja @Repository oznacza ten interfejs jako komponent Spring Bean, co umożliwia automatyczne
 * skanowanie i zarządzanie przez kontener Spring.
 *
 * Interfejs ten jest generyczny, gdzie pierwszym parametrem jest klasa encji (Marka), a drugim
 * parametrem jest typ klucza głównego tej encji (Integer). Dzięki temu interfejsowi, nie trzeba
 * implementować metod CRUD, ponieważ są one dostarczane przez JpaRepository.
 *
 * Dodatkowe niestandardowe metody związane z zapytaniami mogą być dodane, jeśli są potrzebne, ale
 * są one opcjonalne, ponieważ JpaRepository już dostarcza podstawowe operacje związane z bazą danych.
 */
@Repository
public interface MarkaRepository extends JpaRepository<Marka, Integer> {
    // You can add custom query methods if needed
}
