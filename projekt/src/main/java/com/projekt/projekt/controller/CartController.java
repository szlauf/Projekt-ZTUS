// Deklaracja pakietu, w którym znajduje się klasa CartController
package com.projekt.projekt.controller;

// Importowanie niezbędnych klas z frameworka Spring
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Deklaracja klasy kontrolera obsługującej koszyk
@Controller
public class CartController {

    // Metoda obsługująca żądanie GET na ścieżce "/cart"
    @GetMapping("/cart")
    public String cart() {

        // Zwracanie nazwy widoku "cart", który zostanie wyrenderowany dla użytkownika
        return "cart";
    }
    
}
