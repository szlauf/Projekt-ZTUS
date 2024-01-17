package com.projekt.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekt.projekt.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{
    Cart findByIdUser(Integer idUser);
}
