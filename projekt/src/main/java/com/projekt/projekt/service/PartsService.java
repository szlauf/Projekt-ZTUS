package com.projekt.projekt.service;

import com.projekt.projekt.model.Part;
import com.projekt.projekt.repository.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartsService {

    @Autowired
    private PartsRepository partsRepository;

    public List<Part> getAllParts() {
        return partsRepository.findAll();
    }

    /*
     public List<Part> getFilteredParts(String brand, String model, String year, String productionYear) {
    // Implement the logic to fetch filtered parts from the repository
    // You can use the JpaRepository methods for this purpose.
    // Example: partsRepository.findByBrandAndModelAndYearAndProductionYear(brand, model, year, productionYear);
    // Adjust the method and query according to your data model.
    }

     */
}
