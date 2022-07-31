package com.example.educationCrm.repository;

import com.example.educationCrm.model.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
        extends CrudRepository<Student,Long> {
}
