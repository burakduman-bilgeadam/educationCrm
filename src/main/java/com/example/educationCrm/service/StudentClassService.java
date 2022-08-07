package com.example.educationCrm.service;

import com.example.educationCrm.model.dto.StudentClassDTO;
import com.example.educationCrm.model.entity.StudentClass;

public interface StudentClassService {
    void save(String name);
    StudentClass getStudentClassById(Long id);

    void update(StudentClassDTO studentClassDTO);
    void delete(Long id);
}
