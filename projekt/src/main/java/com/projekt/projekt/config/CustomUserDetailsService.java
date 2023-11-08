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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);

        if (user == null) {
            throw new UsernameNotFoundException("Użytkownik o loginie " + username + " nie istnieje.");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getHaslo())
                .roles("USER")
                .build();
    }
}