package com.example.educationCrm.controller;

import com.example.educationCrm.model.dto.TeacherDTO;
import com.example.educationCrm.model.dto.TeacherStudentDTO;
import com.example.educationCrm.model.entity.Teacher;
import com.example.educationCrm.service.TeacherService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public void save(@RequestBody TeacherDTO teacherDTO){
        this.teacherService.save(teacherDTO);
    }

    @PutMapping
    public void update(@RequestBody TeacherDTO teacherDTO){
        this.teacherService.update(teacherDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name="id") Long teacherId){
        this.teacherService.delete(teacherId);
    }

    @GetMapping
    public List<TeacherDTO> findAll(){
        return this.teacherService.findAll();
    }

    @PutMapping("/addStudents")
    public ResponseEntity<Void> addStudents
            (@RequestBody TeacherStudentDTO teacherStudentDTO){
            this.teacherService.addStudents(teacherStudentDTO);
            return new ResponseEntity(
                     HttpStatus.OK);
    }

    @GetMapping("/getStudents")
    public ResponseEntity<Teacher> getStudents
            (@RequestParam Long teacherId){
        try {
            return new ResponseEntity(this.teacherService
                    .withStudents(teacherId), HttpStatus.OK);
        } catch (Exception cve){
            return new ResponseEntity("Aynı Id ile Kayıt Hatası"
                    , HttpStatus.BAD_REQUEST);
        }
    }
}
