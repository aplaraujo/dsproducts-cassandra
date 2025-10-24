package com.example.dsproducts_cassandra.model.dto;

import com.example.dsproducts_cassandra.model.entities.Department;

import java.util.UUID;

public class DepartmentDTO {
    private UUID id;
    private String name;

    public DepartmentDTO() {}

    public DepartmentDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentDTO(Department entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
