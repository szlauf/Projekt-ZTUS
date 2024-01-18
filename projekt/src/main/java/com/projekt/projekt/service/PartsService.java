package com.projekt.projekt.service;

import com.projekt.projekt.model.Part;
import com.projekt.projekt.model.User;
import com.projekt.projekt.repository.PartsRepository;

import jakarta.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartsService {

    @Autowired
    private PartsRepository partsRepository;

    // Komentarz: Klasa serwisowa PartsService zajmuje się logiką biznesową związaną z częściami samochodowymi.

    /**
     * Pobiera wszystkie dostępne części z repozytorium.
     *
     * return Lista obiektów Part reprezentujących wszystkie dostępne części.
     */
    public List<Part> getAllParts() {
        return partsRepository.findAll();
    }

    /**
     * Pobiera filtrowane części na podstawie podanych kryteriów.
     *
     * param brand          Marka części.
     * param smodel         Nazwa modelu samochodu.
     * param generation     Generacja samochodu.
     * param productionYear Rok produkcji samochodu.
     * return Lista obiektów Part reprezentujących części spełniające podane kryteria.
     */

     public List<Part> getFilteredParts(String brand, String model, String generation, Integer productionYear) {
        if ((brand == null || brand.isEmpty()) && (model == null || model.isEmpty()) &&
            (generation == null || generation.isEmpty()) && productionYear == null) {
            // If all parameters are null or empty, return all non-archived parts
            return partsRepository.findByIsArchivedFalse();
        }
    
        // Create a specification for filtering based on the provided parameters
        Specification<Part> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
    
            // ... existing code ...
    
            if (productionYear != null) {
                // Add production year filtering
                predicates.add(criteriaBuilder.equal(root.get("carProductionYear"), productionYear));
            }
    
            // Add condition to exclude archived parts
            predicates.add(criteriaBuilder.equal(root.get("isArchived"), false));
    
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    
        // Apply the specification and return the filtered parts
        return partsRepository.findAll(specification);
    }
    

    
    

    public List<Part> getUserParts(User user){
        return partsRepository.findByUserAndIsArchived(user, false);
    }

    public Part getUserOrders(Integer id){
        return partsRepository.findById(id);
    }

    public Part getPartById(Integer id){
        return partsRepository.findById(id);
    }

    public void deletePart(Long partId) {
        // Implement logic to delete the part by ID
        partsRepository.deleteById(partId);
     }
  
     public void archivePart(Long partId) {
        // Implement logic to archive the part by updating the 'isArchived' field
        Part part = partsRepository.findById(partId).orElse(null);
        if (part != null) {
           part.setIsArchived(true);
           partsRepository.save(part);
        }
     }

    public List<Part> getUserArchive(User user) {
        return partsRepository.findByUserAndIsArchived(user, true); 
    }

    public void unArchivePart(Long partId) {
        Part part = partsRepository.findById(partId).orElse(null);
        if (part != null) {
           part.setIsArchived(false);
           partsRepository.save(part);
        }
    }
}

