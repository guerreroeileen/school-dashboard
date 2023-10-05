package com.yoandroide.schooldashboard.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class Identification {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @NotNull
    private IdentificationType identificationType;
    @NotEmpty
    private String identificationNumber;
    @NotNull
    private LocalDate expeditionDate;
    private LocalDate expirationDate;
}
