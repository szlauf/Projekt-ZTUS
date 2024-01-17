package com.projekt.projekt.controller;

import com.projekt.projekt.model.Model;
import com.projekt.projekt.model.Part;
import com.projekt.projekt.model.User;
import com.projekt.projekt.model.Zdjecie;
import com.projekt.projekt.repository.ModelRepository;
import com.projekt.projekt.repository.PartsRepository;
import com.projekt.projekt.repository.UserRepository;
import com.projekt.projekt.repository.ZdjecieRepository;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/process-product-add")
public class ProcessProductAddController {

    @Autowired 
    private PartsRepository partsRepository;

    @Autowired
    ZdjecieRepository zdjecieRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelRepository modelRepository;

    @PostMapping
    public String processProductAdd(
            @RequestParam("title") String title,
            @RequestParam("image") MultipartFile image,
            @RequestParam("description") String description,
            @RequestParam("brand") String brand,
            @RequestParam("model") String smodel,
            @RequestParam("year") String generation,
            @RequestParam("production-year") Integer productionYear,
            @RequestParam("price") Integer price

    ) {
        Part newPart = new Part();
        newPart.setTitle(title);
        newPart.setDescription(description);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByLogin(username);
        newPart.setUser(user);
        newPart.setCarProductionYear(productionYear);
        newPart.setPrice(price);
        Model model = modelRepository.findByNazwaModeluAndGeneracja(smodel, generation);
        newPart.setModel(model);
        newPart.setIsArchived(false);
        Zdjecie zdjecie = new Zdjecie();
        try {
            zdjecie.setZdjecie(image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        zdjecie.setPart(newPart);
        partsRepository.save(newPart);
        zdjecieRepository.save(zdjecie);
        

        return "redirect:/product-page?id=" + newPart.getId();
    }
}
