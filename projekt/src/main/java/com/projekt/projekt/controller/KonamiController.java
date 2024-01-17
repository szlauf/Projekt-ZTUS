package com.projekt.projekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KonamiController {

    @GetMapping("/konami")
    public String konami() {

        return "konami";
    }

}
