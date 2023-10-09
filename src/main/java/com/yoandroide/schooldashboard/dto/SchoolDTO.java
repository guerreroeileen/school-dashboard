package com.yoandroide.schooldashboard.dto;

import com.yoandroide.schooldashboard.model.Course;

import java.util.List;
import java.util.UUID;

public record SchoolDTO(UUID id, String name, String address, List<Course> courses) {
}
