package com.projekt.projekt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.projekt.projekt.model.DaneUser;
import com.projekt.projekt.model.User;
import com.projekt.projekt.repository.DaneUserRepository;
import com.projekt.projekt.repository.UserRepository;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DaneUserRepository daneUserRepository;

    @GetMapping("/")
    public String helloWorld() {
        return "login";
    }

    @GetMapping("/index")
    public String index(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        User user = userRepository.findByLogin(login);
        DaneUser daneUser = daneUserRepository.findByDaneUserId(user.getDaneUserId());
        model.addAttribute("userLogin", user.getLogin());
        model.addAttribute("userDane", daneUser);

        return "index";
    }
}
