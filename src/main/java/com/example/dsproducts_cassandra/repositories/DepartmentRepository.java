package com.example.dsproducts_cassandra.repositories;

import com.example.dsproducts_cassandra.model.entities.Department;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface DepartmentRepository extends CassandraRepository<Department, UUID> {
}
