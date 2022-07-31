package com.example.educationCrm.service;

import com.example.educationCrm.model.dto.StudentDTO;

import java.text.ParseException;

public interface StudentService {
    void save(StudentDTO studentDto) throws ParseException;
}
