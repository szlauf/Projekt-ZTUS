package com.projekt.projekt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projekt.projekt.model.DaneUser;
import com.projekt.projekt.model.User;
import com.projekt.projekt.repository.DaneUserRepository;
import com.projekt.projekt.repository.UserRepository;


@Controller
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DaneUserRepository daneUserRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    
    @PostMapping("/registration")
    public String register(@RequestParam String login, @RequestParam String password, Model model, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam Integer phoneNumber, @RequestParam String city, @RequestParam String postalCode, @RequestParam String street, @RequestParam String apartmentNumber) {
        
        if (userRepository.findByLogin(login) != null) {
            model.addAttribute("error", "Username already in use. Please choose a different one.");
            return "registration"; // Return to the registration page with an error message
        }

        System.out.print(password+login);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User(login, passwordEncoder.encode(password));
        userRepository.save(user);
        user.setDaneUserId(user.getId());
        userRepository.save(user);
        DaneUser daneUser = new DaneUser(user.getDaneUserId(), firstName, lastName, phoneNumber, city, postalCode, street, apartmentNumber, email);
        daneUserRepository.save(daneUser);

        return "login";
        
    }
    
    
}
