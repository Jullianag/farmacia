package com.projeto.farmacia.dto;

import com.projeto.farmacia.entities.Category;
import com.projeto.farmacia.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

    private Long id;
    @NotBlank(message = "Campo obrigatório")
    @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres!")
    private String name;
    @NotBlank(message = "Campo obrigatório")
    @Size(min = 10, message = "Descrição precisa ter no mínimo 10 caracteres!")
    private String description;
    @Positive(message = "O preço deve ser um número positivo!")
    private Double price;
    private String imgUrl;

    @NotEmpty(message = "Categoria não pode ser vazia")
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO() {
    }

    public ProductDTO(String imgUrl, Double price, String description, String name, Long id) {
        this.imgUrl = imgUrl;
        this.price = price;
        this.description = description;
        this.name = name;
        this.id = id;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();

        for (Category cat : entity.getCategories()) {
            categories.add(new CategoryDTO(cat));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
