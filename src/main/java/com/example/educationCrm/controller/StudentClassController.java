package com.example.educationCrm.controller;

import com.example.educationCrm.model.dto.StudentClassDTO;
import com.example.educationCrm.model.entity.StudentClass;
import com.example.educationCrm.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public StudentClass getStudentClassById
            (@RequestParam Long id){
       return this.studentClassService.getStudentClassById(id);
    }

    @PutMapping
    public void update(@RequestBody StudentClassDTO studentClassDTO){
        this.studentClassService.update(studentClassDTO);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        this.studentClassService.delete(id);
    }
}
