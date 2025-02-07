package com.projeto.farmacia.repositories;

import com.projeto.farmacia.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
