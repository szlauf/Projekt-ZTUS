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

    // Obsługuje żądania GET na "/registration" i zwraca szablon "registration"
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    // Obsługuje żądania POST na "/registration" dotyczące rejestracji użytkownika
    @PostMapping("/registration")
    public String register(@RequestParam String login, @RequestParam String password, Model model, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam Integer phoneNumber, @RequestParam String city, @RequestParam String postalCode, @RequestParam String street, @RequestParam String apartmentNumber) {
        
        // Sprawdza, czy podana nazwa użytkownika jest już używana
        if (userRepository.findByLogin(login) != null) {
            model.addAttribute("error", "Username already in use. Please choose a different one.");
            return "registration"; // Powrót do strony rejestracji z komunikatem błędu
        }

        System.out.print(password+login);
        // Szyfruje hasło przy użyciu BCryptPasswordEncoder
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User(login, passwordEncoder.encode(password));
        
        // Zapisuje użytkownika do UserRepository
        userRepository.save(user);

        // Ustawia DaneUserId dla użytkownika i aktualizuje użytkownika w UserRepository
        user.setDaneUserId(user.getId());
        userRepository.save(user);

        // Tworzy nowego DaneUsera z danymi specyficznymi dla użytkownika
        DaneUser daneUser = new DaneUser(user.getDaneUserId(), firstName, lastName, phoneNumber, city, postalCode, street, apartmentNumber, email);
        
        // Zapisuje DaneUsera do DaneUserRepository
        daneUserRepository.save(daneUser);

        // Przekierowuje do strony logowania po pomyślnej rejestracji
        return "login";
        
    }

    @GetMapping("/registration_eng")
    public String registrationEng() {
        return "registration";
    }

    // Obsługuje żądania POST na "/registration" dotyczące rejestracji użytkownika
    @PostMapping("/registration_eng")
    public String registerEng(@RequestParam String login, @RequestParam String password, Model model, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam Integer phoneNumber, @RequestParam String city, @RequestParam String postalCode, @RequestParam String street, @RequestParam String apartmentNumber) {
        
        // Sprawdza, czy podana nazwa użytkownika jest już używana
        if (userRepository.findByLogin(login) != null) {
            model.addAttribute("error", "Username already in use. Please choose a different one.");
            return "registration"; // Powrót do strony rejestracji z komunikatem błędu
        }

        System.out.print(password+login);
        // Szyfruje hasło przy użyciu BCryptPasswordEncoder
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User(login, passwordEncoder.encode(password));
        
        // Zapisuje użytkownika do UserRepository
        userRepository.save(user);

        // Ustawia DaneUserId dla użytkownika i aktualizuje użytkownika w UserRepository
        user.setDaneUserId(user.getId());
        userRepository.save(user);

        // Tworzy nowego DaneUsera z danymi specyficznymi dla użytkownika
        DaneUser daneUser = new DaneUser(user.getDaneUserId(), firstName, lastName, phoneNumber, city, postalCode, street, apartmentNumber, email);
        
        // Zapisuje DaneUsera do DaneUserRepository
        daneUserRepository.save(daneUser);

        // Przekierowuje do strony logowania po pomyślnej rejestracji
        return "login_eng";
        
    }
    
    
}
