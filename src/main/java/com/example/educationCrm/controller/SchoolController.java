package com.example.educationCrm.controller;

import com.example.educationCrm.model.dto.SchoolDTO;
import com.example.educationCrm.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public ResponseEntity saveSchool(@RequestBody SchoolDTO schoolDTO){
        this.schoolService.save(schoolDTO.getName());
        return new ResponseEntity("Başarılı İşlem"
                ,HttpStatus.CREATED);
    }
}
