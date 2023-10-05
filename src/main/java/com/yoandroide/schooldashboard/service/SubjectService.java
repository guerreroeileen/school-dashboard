package com.yoandroide.schooldashboard.service;

import com.yoandroide.schooldashboard.model.Subject;
import com.yoandroide.schooldashboard.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public Page<Subject> findSubjects(Integer page, Integer size, Boolean enablePagination) {
        return this.subjectRepository.findAll(enablePagination ? PageRequest.of(page, size): Pageable.unpaged());
    }
}
