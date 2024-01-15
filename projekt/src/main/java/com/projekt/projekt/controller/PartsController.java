package com.projekt.projekt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.projekt.projekt.Utils.ImageUtils;
import com.projekt.projekt.model.Part;
import com.projekt.projekt.model.Zdjecie;
import com.projekt.projekt.service.PartsService;

@Controller
public class PartsController {

    @Autowired
    private PartsService partsService;

    @GetMapping("/czesci")
    public String czesci(ModelMap model) {
        List<Part> parts = partsService.getAllParts();

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
}
