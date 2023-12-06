package com.projekt.projekt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.projekt.projekt.model.Marka;
import com.projekt.projekt.model.Model;
import com.projekt.projekt.repository.MarkaRepository;
import com.projekt.projekt.repository.ModelRepository;

@Controller
public class IndexController {

    @Autowired
    private MarkaRepository markaRepository;

    @Autowired
    private ModelRepository modelRepository;

    @GetMapping("/index")
    public String index(ModelMap model) {
        List<Marka> marki = markaRepository.findAll();
        List<Model> models = modelRepository.findAll();
        model.addAttribute("marki", marki);
        model.addAttribute("models", models);
        return "index";
    }
    
}
