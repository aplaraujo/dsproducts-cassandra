package com.example.dsproducts_cassandra.services;

import com.example.dsproducts_cassandra.model.dto.DepartmentDTO;
import com.example.dsproducts_cassandra.model.entities.Department;
import com.example.dsproducts_cassandra.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentDTO> findAll() {
        List<Department> list = departmentRepository.findAll();
        return list.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
    }
}
