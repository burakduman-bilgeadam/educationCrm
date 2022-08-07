package com.example.educationCrm.serviceImp;

import com.example.educationCrm.model.dto.StudentClassDTO;
import com.example.educationCrm.model.entity.StudentClass;
import com.example.educationCrm.repository.StudentClassRepository;
import com.example.educationCrm.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    @Transactional(readOnly = true)
    @Override
    public StudentClass getStudentClassById(Long id) {
        return this.studentClassRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void update(StudentClassDTO studentClassDTO) {
       Optional<StudentClass> studentClassO =
               this.studentClassRepository
                .findById(studentClassDTO.getId());
       if(studentClassO.isPresent()){
           StudentClass studentClass = studentClassO.get();
           studentClass.setName(studentClassDTO.getName());
           this.studentClassRepository.save(studentClass);
       }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        this.studentClassRepository.deleteById(id);
    }
}
