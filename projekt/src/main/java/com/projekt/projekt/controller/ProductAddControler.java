package com.projekt.projekt.controller;

// Importowanie niezbędnych klas z frameworka Spring.
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Klasa kontrolera do obsługi dodawania produktów.
@Controller
public class ProductAddControler {

    // Metoda obsługująca żądanie GET na ścieżce "/product-add".
    @GetMapping("/product-add")
    public String productAdd() {
        // Zwraca nazwę widoku "product-add". 
        // W praktyce oznacza to, że po odwołaniu się do ścieżki "/product-add", 
        // zostanie wyrenderowany szablon o nazwie "product-add".
        return "product-add";
    }
    
}
