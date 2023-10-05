package com.yoandroide.schooldashboard.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class SubjectCourseTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Course course;

}
