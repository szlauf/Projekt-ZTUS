package com.projekt.projekt.controller;

// Importowanie niezbędnych klas z frameworku Spring
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Klasa kontrolera obsługująca żądania związane z kontaktem
@Controller
public class ContactController {

    // Metoda obsługująca żądanie GET na ścieżce "/contact"
    @GetMapping("/contact")
    public String contact() {
        // Zwraca nazwę widoku "contact", który zostanie wyrenderowany
        return "contact";
    }

    // Metoda obsługująca żądanie GET na ścieżce "/contact"
    @GetMapping("/contact_eng")
    public String contactEng() {
        // Zwraca nazwę widoku "contact", który zostanie wyrenderowany
        return "contact_eng";
    }
    
}
