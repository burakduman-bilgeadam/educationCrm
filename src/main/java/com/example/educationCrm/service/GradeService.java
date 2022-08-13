package com.example.educationCrm.service;

import com.example.educationCrm.model.dto.GradeDTO;
import com.example.educationCrm.model.dto.GradeFilterLessonDTO;
import com.example.educationCrm.model.entity.Grade;

import java.util.List;

public interface GradeService {
    public void update(GradeDTO gradeDTO);
    public void save(GradeDTO gradeDTO);
    public void delete(Long id);
    public List<GradeDTO> findAll();

    public List<Object>getGradesByLessonName(String lessonName);
    public List<GradeFilterLessonDTO>getGradesByLessonNameWithDerived(String lessonName);
    public List<GradeDTO> getEntegrationGrade();
}
