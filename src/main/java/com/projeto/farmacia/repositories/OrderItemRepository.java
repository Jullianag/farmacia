package com.projeto.farmacia.repositories;

import com.projeto.farmacia.entities.Order;
import com.projeto.farmacia.entities.OrderItem;
import com.projeto.farmacia.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
