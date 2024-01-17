package com.projekt.projekt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projekt.projekt.Utils.ImageUtils;
import com.projekt.projekt.model.Marka;
import com.projekt.projekt.model.Model;
import com.projekt.projekt.model.Part;
import com.projekt.projekt.model.Zdjecie;
import com.projekt.projekt.repository.MarkaRepository;
import com.projekt.projekt.repository.ModelRepository;
import com.projekt.projekt.service.PartsService;

@Controller
public class PartsController {

    @Autowired
    private PartsService partsService;

    @Autowired
    private MarkaRepository markaRepository;

    @Autowired
    private ModelRepository modelRepository;

    /*
    @GetMapping("/czesci")
    public String czesci(ModelMap model) {
        List<Part> parts = partsService.getAllParts();
        List<Marka> marki = markaRepository.findAll();
        List<Model> models = modelRepository.findAll();
        model.addAttribute("marki", marki);
        model.addAttribute("models", models);

        // Populate images and base64 for the first image
        parts.forEach(part -> {
            List<Zdjecie> zdjecia = part.getZdjecia();
            if (zdjecia != null && !zdjecia.isEmpty()) {
                part.setBase64Image(ImageUtils.encodeByteArrayToBase64(zdjecia.get(0).getZdjecie()));
            }
        });

        model.addAttribute("parts", parts);
        return "czesci";
    }
    */
    @GetMapping("/parts-filter")
    public String czesci(@RequestParam(name = "price", required = false) Integer price,
                        @RequestParam(name = "brand", required = false) String brand,
                        @RequestParam(name = "model", required = false) String smodel,
                        @RequestParam(name = "generation", required = false) String generation,
                        @RequestParam(name = "productionYear", required = false) Integer productionYear,
                        @RequestParam(name = "type", required = false) String type,
                        ModelMap model) {

    List<Part> parts = partsService.getFilteredParts(price, brand, smodel, generation, productionYear, type);
    List<Marka> marki = markaRepository.findAll();
    List<Model> models = modelRepository.findAll();
    model.addAttribute("marki", marki);
    model.addAttribute("models", models);

    // Populate images and base64 for the first image
    parts.forEach(part -> {
        List<Zdjecie> zdjecia = part.getZdjecia();
        if (zdjecia != null && !zdjecia.isEmpty()) {
            part.setBase64Image(ImageUtils.encodeByteArrayToBase64(zdjecia.get(0).getZdjecie()));
        }
    });

    model.addAttribute("parts", parts);
    return "parts-filter";
}
 
    
}
