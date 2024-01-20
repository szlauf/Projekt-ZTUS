package com.projekt.projekt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.projekt.projekt.model.Marka;
import com.projekt.projekt.model.Model;
import com.projekt.projekt.model.User;
import com.projekt.projekt.repository.MarkaRepository;
import com.projekt.projekt.repository.ModelRepository;
import com.projekt.projekt.service.UserService;

// Oznaczenie klasy jako kontrolera Spring
@Controller
public class IndexController {

    // Wstrzykiwanie zależności za pomocą adnotacji @Autowired
    // Wstrzyknięcie repozytorium dla obiektów Marka
    @Autowired
    private MarkaRepository markaRepository;

    // Wstrzyknięcie repozytorium dla obiektów Model
    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private UserService userService;

    // Mapowanie ścieżki "/index" na metodę obsługującą żądanie GET
    @GetMapping("/index")
    public String index(ModelMap model) {
        // Pobranie wszystkich obiektów Marka z repozytorium
        List<Marka> marki = markaRepository.findAll();
        
        // Pobranie wszystkich obiektów Model z repozytorium
        List<Model> models = modelRepository.findAll();

        List<User> users = userService.getUsersWithHighestAverageRating(5); // 5 - liczba użytkowników do wyświetlenia
        model.addAttribute("users", users);

        // Dodanie obiektów Marka i Model do modelu, który zostanie przekazany do widoku
        model.addAttribute("marki", marki);
        model.addAttribute("models", models);

        // Zwrócenie nazwy widoku, który zostanie wyrenderowany dla tej ścieżki
        return "index";
    }

    @GetMapping("/index_eng")
    public String indexEng(ModelMap model) {
        // Pobranie wszystkich obiektów Marka z repozytorium
        List<Marka> marki = markaRepository.findAll();
        
        // Pobranie wszystkich obiektów Model z repozytorium
        List<Model> models = modelRepository.findAll();

        // Dodanie obiektów Marka i Model do modelu, który zostanie przekazany do widoku
        model.addAttribute("marki", marki);
        model.addAttribute("models", models);

        // Zwrócenie nazwy widoku, który zostanie wyrenderowany dla tej ścieżki
        return "index_eng";
    }
    
}
