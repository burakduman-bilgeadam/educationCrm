package com.example.educationCrm.controller;

import com.example.educationCrm.model.dto.SchoolDTO;
import com.example.educationCrm.model.dto.SchoolInformationDTO;
import com.example.educationCrm.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping
    public ResponseEntity update(@RequestBody SchoolDTO schoolDTO){
        this.schoolService.update(schoolDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody SchoolDTO schoolDTO){
        this.schoolService.delete(schoolDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<SchoolInformationDTO> getAllName(){
        return this.schoolService.findAllName();
    }
}
