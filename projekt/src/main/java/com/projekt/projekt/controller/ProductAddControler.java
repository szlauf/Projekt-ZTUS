package com.projekt.projekt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// Importowanie niezbędnych klas z frameworka Spring.
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.projekt.projekt.model.Marka;
import com.projekt.projekt.model.Model;
import com.projekt.projekt.repository.MarkaRepository;
import com.projekt.projekt.repository.ModelRepository;

// Klasa kontrolera do obsługi dodawania produktów.
@Controller
public class ProductAddControler {

    @Autowired
    private MarkaRepository markaRepository;

    // Wstrzyknięcie repozytorium dla obiektów Model
    @Autowired
    private ModelRepository modelRepository;


    // Metoda obsługująca żądanie GET na ścieżce "/product-add".
    @GetMapping("/product-add")
    public String productAdd(ModelMap model) {
        // Zwraca nazwę widoku "product-add". 
        // W praktyce oznacza to, że po odwołaniu się do ścieżki "/product-add", 
        // zostanie wyrenderowany szablon o nazwie "product-add".

        List<Marka> marki = markaRepository.findAll();
        
        // Pobranie wszystkich obiektów Model z repozytorium
        List<Model> models = modelRepository.findAll();

        // Dodanie obiektów Marka i Model do modelu, który zostanie przekazany do widoku
        model.addAttribute("marki", marki);
        model.addAttribute("models", models);

        return "product-add";
    }

    @GetMapping("/product-add_eng")
    public String productAddEng(ModelMap model) {
        List<Marka> marki = markaRepository.findAll();
        
        // Pobranie wszystkich obiektów Model z repozytorium
        List<Model> models = modelRepository.findAll();

        // Dodanie obiektów Marka i Model do modelu, który zostanie przekazany do widoku
        model.addAttribute("marki", marki);
        model.addAttribute("models", models);
        return "product-add_eng";
    }
    
}
