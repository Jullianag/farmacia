package com.projeto.farmacia.repositories;

import com.projeto.farmacia.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
