package com.projekt.projekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Oznaczenie klasy jako kontrolera w Springu
@Controller
public class ProfileController {

    // Metoda obsługująca żądania GET na ścieżce "/profile"
    @GetMapping("/profile")
    public String profile() {
        // Zwracanie nazwy widoku (szablonu) o nazwie "profile"
        return "profile";
    }
    
}
