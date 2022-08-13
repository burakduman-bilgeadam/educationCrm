package com.example.educationCrm.service;

import com.example.educationCrm.model.dto.StudentDTO;
import com.example.educationCrm.model.dto.StudentInformationDTO;
import com.example.educationCrm.model.entity.Student;
import com.example.educationCrm.repository.StudentRepository;

import java.text.ParseException;
import java.util.List;

public interface StudentService {
    void save(StudentDTO studentDto) throws ParseException;
    StudentInformationDTO getNameSurnameById(Long id);

    void update(StudentDTO studentDTO);
    void delete(Long id);

    List<StudentInformationDTO> getBySchoolName(String schoolName);

    Student findById(Long id);
}
