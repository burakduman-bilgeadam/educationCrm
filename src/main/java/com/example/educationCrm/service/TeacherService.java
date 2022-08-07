package com.example.educationCrm.service;

import com.example.educationCrm.model.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {

    void save(TeacherDTO teacherDTO);
    void update(TeacherDTO teacherDTO);
    void delete(Long id);
    List<TeacherDTO> findAll();
}
