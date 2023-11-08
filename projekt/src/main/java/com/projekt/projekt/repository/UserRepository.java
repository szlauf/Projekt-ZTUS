package com.projekt.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekt.projekt.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login); //wyszukaj użytkownia po loginie
    User findUserById(Integer id);
}
