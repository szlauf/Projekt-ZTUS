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
}
