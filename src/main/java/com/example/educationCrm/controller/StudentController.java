package com.example.educationCrm.controller;

import com.example.educationCrm.model.dto.StudentDTO;
import com.example.educationCrm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping
    public ResponseEntity saveStudent(
            @RequestBody StudentDTO studentDTO) throws ParseException {
        this.studentService.save(studentDTO);
        return new ResponseEntity("Başarılı Kayıt"
                , HttpStatus.CREATED);
    }
}
