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

    public List<Part> getAllParts() {
        return partsRepository.findAll();
    }

    
    public List<Part> getFilteredParts(String brand, String smodel, String year, String productionYear) {
        Model model = modelRepository.findByNazwaModeluAndGeneracja(smodel, year);
        Integer iproductionYear = null;
        if(productionYear!=null)
            iproductionYear = Integer.valueOf(productionYear);
        return partsRepository.findByModelAndCarProductionYear(model, iproductionYear);
    }

    
}
