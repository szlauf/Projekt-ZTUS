package com.projekt.projekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Deklaracja kontrolera o nazwie ProductPageController
@Controller
public class ProductPageController {

    // Metoda obsługująca żądania GET na ścieżce "/product-page"
    @GetMapping("/product-page")
    public String producPage() {
         // Zwracanie nazwy widoku "product-page", który zostanie wyrenderowany w wyniku żądania
        return "product-page";
    }
    
    
}
