package com.projeto.farmacia.services;

import com.projeto.farmacia.dto.CategoryDTO;
import com.projeto.farmacia.dto.OrderDTO;
import com.projeto.farmacia.dto.ProductDTO;
import com.projeto.farmacia.dto.ProductMinDTO;
import com.projeto.farmacia.entities.Category;
import com.projeto.farmacia.entities.Order;
import com.projeto.farmacia.entities.Product;
import com.projeto.farmacia.repositories.OrderRepository;
import com.projeto.farmacia.repositories.ProductRepository;
import com.projeto.farmacia.services.exceptions.DatabaseException;
import com.projeto.farmacia.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id não encontrado")
        );
        return new OrderDTO(order);
    }

}
