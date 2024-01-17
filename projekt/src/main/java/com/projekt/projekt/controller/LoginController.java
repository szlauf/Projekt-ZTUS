package com.projekt.projekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Klasa pełniąca rolę kontrolera w aplikacji.
@Controller
public class LoginController {

    // Metoda obsługująca żądanie GET na ścieżce "/login".
    @GetMapping("/login")
    public String login() {

        // Zwracanie nazwy widoku "login", który zostanie wyrenderowany dla użytkownika.
        return "login";
    }

    // Metoda obsługująca żądanie GET na ścieżce "/login".
    @GetMapping("/login_eng")
    public String loginEng() {

        // Zwracanie nazwy widoku "login", który zostanie wyrenderowany dla użytkownika.
        return "login_eng";
    }

}
