package com.projekt.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekt.projekt.model.User;

// Interfejs UserRepository rozszerza interfejs JpaRepository, dostarczając podstawowe operacje CRUD dla encji User
public interface UserRepository extends JpaRepository<User, Integer> {

    // Metoda findByLogin pozwala na wyszukiwanie użytkownika po jego nazwie użytkownika (loginie)
    User findByLogin(String login); 

    // Metoda findUserById pozwala na wyszukiwanie użytkownika po jego identyfikatorze (id)
    User findUserById(Integer id);
}
