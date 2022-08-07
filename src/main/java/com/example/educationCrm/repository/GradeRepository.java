package com.example.educationCrm.repository;

import com.example.educationCrm.model.entity.Grade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository
        extends CrudRepository<Grade,Long> {
}
