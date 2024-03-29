package com.projekt.projekt.repository;

import com.projekt.projekt.model.Model;
import com.projekt.projekt.model.Part;
import com.projekt.projekt.model.User;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

// Deklaracja interfejsu PartsRepository rozszerzającego JpaRepository, który obsługuje operacje na bazie danych dla encji Part o identyfikatorze Long
public interface PartsRepository extends JpaRepository<Part, Long> {

    // Deklaracja metody findByModelAndCarProductionYear, która będzie generować zapytanie do bazy danych w celu znalezienia listy części na podstawie modelu i roku produkcji samochodu
    // Parametry:
    // - model: obiekt klasy Model, reprezentujący model samochodu
    // - carProductionYear: rok produkcji samochodu
    // Zwraca:
    // - Lista obiektów klasy Part spełniających kryteria wyszukiwania
    List<Part> findByModelAndCarProductionYear(Model model, Integer carProductionYear);
    List<Part> findByUser(User user);
    Part findById(Integer id);
    List<Part> findByModel(Model model);
    List<Part> findByCarProductionYear(Integer productionYear);
    List<Part> findAll(Specification<Part> specification);
    List<Part> findByIsArchivedFalse();
    List<Part> findByUserAndIsArchived(User user, boolean b);
}
