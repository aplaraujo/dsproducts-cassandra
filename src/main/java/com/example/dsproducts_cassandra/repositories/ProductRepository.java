package com.example.dsproducts_cassandra.repositories;

import com.example.dsproducts_cassandra.model.entities.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ProductRepository extends CassandraRepository<Product, UUID> {
}
