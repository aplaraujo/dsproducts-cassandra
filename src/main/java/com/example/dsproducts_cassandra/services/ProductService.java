package com.example.dsproducts_cassandra.services;

import com.example.dsproducts_cassandra.model.dto.ProductDTO;
import com.example.dsproducts_cassandra.model.entities.Product;
import com.example.dsproducts_cassandra.repositories.ProductRepository;
import com.example.dsproducts_cassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductDTO findById(UUID id) {
        Product entity = getById(id);
        return new ProductDTO(entity);
    }

    public List<ProductDTO> findByDepartment(String department) {
        List<Product> list;
        if ("".equals(department)) {
            list = productRepository.findAll();
        } else {
            list = productRepository.findByDepartment(department);
        }
        return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }

    public List<ProductDTO> findByDescription(String text) {
        List<Product> list = productRepository.findByDescription("%"+text+"%");
        return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }

    private Product getById(UUID id) {
        Optional<Product> result = productRepository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
    }

}
