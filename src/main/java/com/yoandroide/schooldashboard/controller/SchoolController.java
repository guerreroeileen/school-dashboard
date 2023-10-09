package com.yoandroide.schooldashboard.controller;

import com.yoandroide.schooldashboard.dto.SchoolDTO;
import com.yoandroide.schooldashboard.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService service;

    @PostMapping
    public ResponseEntity<SchoolDTO> saveSchool(@RequestBody SchoolDTO schoolDTO){
        SchoolDTO savedSchool = this.service.save(schoolDTO);
        URI location = URI.create(new StringBuilder().append("/school/").append(savedSchool.id()).toString());
        return ResponseEntity.created(location).body(savedSchool);
    }

    @GetMapping("{id}")
    public ResponseEntity<SchoolDTO> findSchoolById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(this.service.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<SchoolDTO>> findAllSchools(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                          @RequestParam(required = false, defaultValue = "10") Integer size,
                                                          @RequestParam(required = false, defaultValue = "false") Boolean enablePagination) {
        Page<SchoolDTO> schools = this.service.findSchools(page, size, enablePagination);
        return ResponseEntity.ok(schools);
    }

    @PutMapping("{id}")
    public ResponseEntity<SchoolDTO> updateSchool(@PathVariable("id") UUID id, @RequestBody SchoolDTO schoolDTO) {
        SchoolDTO updatedSchool = this.service.update(id, schoolDTO);
        return ResponseEntity.ok(updatedSchool);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable("id") UUID id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
