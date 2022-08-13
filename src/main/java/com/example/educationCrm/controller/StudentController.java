package com.example.educationCrm.controller;

import com.example.educationCrm.model.dto.StudentDTO;
import com.example.educationCrm.model.dto.StudentInformationDTO;
import com.example.educationCrm.repository.StudentRepository;
import com.example.educationCrm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

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

    @GetMapping("/getNameSurname")
    public ResponseEntity<StudentInformationDTO>
                getNameSurnameById(@RequestParam Long id){
        return new ResponseEntity<>(
                this.studentService.getNameSurnameById(id),HttpStatus.OK);
    }

    @PutMapping
    public void update(@RequestBody StudentDTO studentDTO){
        this.studentService.update(studentDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.studentService.delete(id);
    }

    @GetMapping("/getBySchoolName")
    public List<StudentInformationDTO> getBySchoolName
            (@RequestParam String schoolName){
        return this.studentService.getBySchoolName(schoolName);
    }
}
