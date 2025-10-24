package com.example.dsproducts_cassandra.services;

import com.example.dsproducts_cassandra.model.dto.ProductDTO;
import com.example.dsproducts_cassandra.model.entities.Product;
import com.example.dsproducts_cassandra.repositories.ProductRepository;
import com.example.dsproducts_cassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductDTO findById(UUID id) {
        Product entity = getById(id);
        return new ProductDTO(entity);
    }

    private Product getById(UUID id) {
        Optional<Product> result = productRepository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
    }
}
