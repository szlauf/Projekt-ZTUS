package com.projekt.projekt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.projekt.projekt.model.User;
import com.projekt.projekt.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // Klasa CustomUserDetailsService implementuje interfejs UserDetailsService,
    // co umożliwia niestandardowe ładowanie danych użytkownika dla Spring Security.

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Metoda loadUserByUsername jest wywoływana przez Spring Security, gdy użytkownik próbuje się zalogować.

        // Pobieranie użytkownika z bazy danych na podstawie loginu.
        User user = userRepository.findByLogin(username);

        // Jeśli użytkownik o podanym loginie nie istnieje, rzuć wyjątek UsernameNotFoundException.
        if (user == null) {
            throw new UsernameNotFoundException("Użytkownik o loginie " + username + " nie istnieje.");
        }

        // Zwracanie obiektu UserDetails, który reprezentuje użytkownika w systemie.
        // W tym przypadku używamy prostego builder'a z Spring Security, aby utworzyć UserDetails.
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getHaslo()) // Hasło użytkownika pobierane z bazy danych.
                .roles("USER") // Nadanie roli "USER".
                .build();
    }
}