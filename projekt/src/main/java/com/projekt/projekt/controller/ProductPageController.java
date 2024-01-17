package com.projekt.projekt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projekt.projekt.model.DaneUser;
import com.projekt.projekt.model.Ocena;
import com.projekt.projekt.model.Part;
import com.projekt.projekt.model.User;
import com.projekt.projekt.repository.DaneUserRepository;
import com.projekt.projekt.repository.OcenaRepository;
import com.projekt.projekt.service.PartsService;

// Deklaracja kontrolera o nazwie ProductPageController
@Controller
public class ProductPageController {
         
    @Autowired
    PartsService partsService;

    @Autowired
    DaneUserRepository daneUserRepository;

    @Autowired
    OcenaRepository ocenaRepository;
    // Metoda obsługująca żądania GET na ścieżce "/product-page"
    @GetMapping("/product-page")
    public String producPage(@RequestParam(name = "id", required = true) Integer id,
                                ModelMap model) {
        
        Part part = partsService.getPartById(id);
        User user = part.getUser();
        DaneUser daneUser = daneUserRepository.findByDaneUserId(user.getDaneUserId());
        List<Ocena> oceny = ocenaRepository.findByIdUser(user.getDaneUserId());
        Integer ocena = 0;
        if(!oceny.isEmpty()){
            int i = 0;
            int suma = 0;
            for(Ocena o : oceny){
                i++;
                suma+=o.getOcena();
            }
            ocena=suma/i;
        }

        model.addAttribute("part", part);
        model.addAttribute("ocena", ocena);
        model.addAttribute("daneUser", daneUser);
        model.addAttribute("user", user);

        // Zwracanie nazwy widoku "product-page", który zostanie wyrenderowany w wyniku żądania
        return "product-page";
    }

    @GetMapping("/product-page_eng")
    public String producPageEng(@RequestParam(name = "id", required = true) Integer id,
                                ModelMap model) {
        
        Part part = partsService.getPartById(id);
        User user = part.getUser();
        DaneUser daneUser = daneUserRepository.findByDaneUserId(user.getDaneUserId());
        List<Ocena> oceny = ocenaRepository.findByIdUser(user.getDaneUserId());
        Integer ocena = 0;
        if(!oceny.isEmpty()){
            int i = 0;
            int suma = 0;
            for(Ocena o : oceny){
                i++;
                suma+=o.getOcena();
            }
            ocena=suma/i;
        }

        model.addAttribute("part", part);
        model.addAttribute("ocena", ocena);
        model.addAttribute("daneUser", daneUser);
        model.addAttribute("user", user);

        // Zwracanie nazwy widoku "product-page", który zostanie wyrenderowany w wyniku żądania
        return "product-page_eng";
    }
    
    
}
