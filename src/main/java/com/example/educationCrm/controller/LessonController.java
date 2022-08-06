package com.example.educationCrm.controller;

import com.example.educationCrm.model.dto.LessonDTO;
import com.example.educationCrm.model.entity.Lesson;
import com.example.educationCrm.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLDataException;
import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveLesson(@RequestBody LessonDTO lessonDTO){
        this.lessonService.save(lessonDTO.getName());
    }

    @PutMapping
    public ResponseEntity update(@RequestBody LessonDTO lessonDTO){
        this.lessonService.update(lessonDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id){
        this.lessonService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<LessonDTO>> findAll(){
        return new ResponseEntity<>(this.lessonService.findAll()
                , HttpStatus.OK);
    }

}
