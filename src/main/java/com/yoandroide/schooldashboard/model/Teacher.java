package com.yoandroide.schooldashboard.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Teacher extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private Boolean isFullTime;
}
