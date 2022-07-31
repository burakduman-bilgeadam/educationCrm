package com.example.educationCrm.controller;

import com.example.educationCrm.model.dto.StudentClassDTO;
import com.example.educationCrm.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentClass")
public class StudentClassController {
    @Autowired
    private StudentClassService studentClassService;

    @PostMapping
    public void saveStudentClass(
            @RequestBody StudentClassDTO studentClassDTO){
        this.studentClassService.save(studentClassDTO.getName());
    }
}
