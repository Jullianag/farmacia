package com.projeto.farmacia.repositories;

import com.projeto.farmacia.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
