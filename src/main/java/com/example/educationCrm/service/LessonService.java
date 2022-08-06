package com.example.educationCrm.service;

import com.example.educationCrm.model.dto.LessonDTO;

import java.sql.SQLDataException;
import java.util.List;

public interface LessonService {
    public void save(String name);
    public void update(LessonDTO lessonDTO);
    public void delete(Long id);
    public List<LessonDTO> findAll();
}
