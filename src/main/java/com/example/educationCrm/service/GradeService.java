package com.example.educationCrm.service;

import com.example.educationCrm.model.dto.GradeDTO;

import java.util.List;

public interface GradeService {
    public void update(GradeDTO gradeDTO);
    public void save(GradeDTO gradeDTO);
    public void delete(Long id);
    public List<GradeDTO> findAll();
}
