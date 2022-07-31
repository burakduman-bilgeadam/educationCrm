package com.example.educationCrm.serviceImp;

import com.example.educationCrm.model.entity.StudentClass;
import com.example.educationCrm.repository.StudentClassRepository;
import com.example.educationCrm.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StudentClassImp implements StudentClassService {
    @Autowired
    private StudentClassRepository studentClassRepository;

    @Transactional
    @Override
    public void save(String name) {
        StudentClass studentClass = new StudentClass();
        studentClass.setName(name);
        this.studentClassRepository.save(studentClass);
    }
}
