package com.yoandroide.schooldashboard.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String address;
    @OneToMany
    private List<Course> courses;
}
