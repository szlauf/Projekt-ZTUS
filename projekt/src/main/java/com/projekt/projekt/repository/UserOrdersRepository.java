package com.projekt.projekt.repository;

import com.projekt.projekt.model.UserOrders;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrdersRepository extends JpaRepository<UserOrders, Long> {
    List<UserOrders> findByIdUser(Integer idUser);
}