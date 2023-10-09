package com.yoandroide.schooldashboard.service;

import com.yoandroide.schooldashboard.dto.SchoolDTO;
import com.yoandroide.schooldashboard.exception.SchoolNotFoundException;
import com.yoandroide.schooldashboard.model.School;
import com.yoandroide.schooldashboard.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository repository;
    private final ModelMapper mapper;

    public Page<SchoolDTO> findSchools(Integer page, Integer size, Boolean enablePagination) {
        Page<School> schools = this.repository.findAll(enablePagination ? PageRequest.of(page, size) : Pageable.unpaged());
        return schools.map(school -> this.mapper.map(school, SchoolDTO.class));
    }

    public SchoolDTO save(SchoolDTO schoolDTO) {
        return this.mapper.map(this.repository.save(this.mapper.map(schoolDTO, School.class)), SchoolDTO.class);
    }

    public SchoolDTO update(UUID id, SchoolDTO schoolDTO) {
        School schoolToUpdate = this.repository.findById(id).orElseThrow(() -> new SchoolNotFoundException(String.format("School with id %s not found for update", id)));
        schoolToUpdate.setName(schoolDTO.name());
        schoolToUpdate.setAddress(schoolDTO.address());
        return this.mapper.map(this.repository.save(schoolToUpdate), SchoolDTO.class);

    }

    public SchoolDTO findById(UUID id) {
        return this.mapper.map(this.repository.findById(id).orElseThrow(() -> new SchoolNotFoundException("School not found")), SchoolDTO.class);
    }

    public void delete(UUID id) {
        this.repository.findById(id).ifPresentOrElse(this.repository::delete, () -> {
            throw new SchoolNotFoundException("School not found");
        });
    }
}
