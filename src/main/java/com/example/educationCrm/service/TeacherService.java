package com.example.educationCrm.service;

import com.example.educationCrm.model.dto.TeacherDTO;
import com.example.educationCrm.model.dto.TeacherStudentDTO;
import com.example.educationCrm.model.entity.Teacher;

import java.util.List;

public interface TeacherService {

    void save(TeacherDTO teacherDTO);
    void update(TeacherDTO teacherDTO);
    void delete(Long id);
    List<TeacherDTO> findAll();
    void addStudents(TeacherStudentDTO teacherStudentDTO);

    Teacher withStudents(Long id) throws Exception;
}
