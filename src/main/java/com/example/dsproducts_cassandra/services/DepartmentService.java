package com.example.dsproducts_cassandra.services;

import com.example.dsproducts_cassandra.model.dto.DepartmentDTO;
import com.example.dsproducts_cassandra.model.entities.Department;
import com.example.dsproducts_cassandra.repositories.DepartmentRepository;
import com.example.dsproducts_cassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentDTO> findAll() {
        List<Department> list = departmentRepository.findAll();
        return list.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
    }

    public DepartmentDTO findById(UUID id) {
        Department entity = getById(id);
        return new DepartmentDTO(entity);
    }

    public DepartmentDTO insert(DepartmentDTO dto) {
        Department entity = new Department();
        entity.setId(UUID.randomUUID());
        copyDtoToEntity(dto, entity);
        entity = departmentRepository.save(entity);
        return new DepartmentDTO(entity);
    }

    public DepartmentDTO update(UUID id, DepartmentDTO dto) {
        Department entity = getById(id);
        copyDtoToEntity(dto, entity);
        entity = departmentRepository.save(entity);
        return new DepartmentDTO(entity);
    }

    public void delete(UUID id) {
        if (!departmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Id não encontrado!");
        }
        departmentRepository.deleteById(id);
    }

    private void copyDtoToEntity(DepartmentDTO dto, Department entity) {
        entity.setName(dto.getName());
    }

    private Department getById(UUID id) {
        Optional<Department> result = departmentRepository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));
    }

}
