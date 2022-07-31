package com.example.educationCrm.serviceImp;

import com.example.educationCrm.model.entity.School;
import com.example.educationCrm.repository.SchoolRepository;
import com.example.educationCrm.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SchoolServiceImp implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Transactional
    @Override
    public void save(String name) {
        School school = new School(name);
        this.schoolRepository.save(school);
    }
}
