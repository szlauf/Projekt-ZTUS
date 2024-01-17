package com.projekt.projekt.service;

import com.projekt.projekt.model.Model;
import com.projekt.projekt.model.Part;
import com.projekt.projekt.repository.ModelRepository;
import com.projekt.projekt.repository.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartsService {

    @Autowired
    private PartsRepository partsRepository;

    @Autowired
    private ModelRepository modelRepository;

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
     * param price          Cena części.
     * param brand          Marka części.
     * param smodel         Nazwa modelu samochodu.
     * param generation     Generacja samochodu.
     * param productionYear Rok produkcji samochodu.
     * param type           Typ części.
     * return Lista obiektów Part reprezentujących części spełniające podane kryteria.
     */
    public List<Part> getFilteredParts(Integer price, String brand, String smodel, String generation, Integer productionYear, String type) {

        // Komentarz: Wyszukiwanie modelu na podstawie nazwy modelu i generacji.
        Model model = modelRepository.findByNazwaModeluAndGeneracja(smodel, generation);
        // Komentarz: Pobieranie części na podstawie modelu i roku produkcji samochodu.
        return partsRepository.findByModelAndCarProductionYear(model, productionYear);
    }
}

