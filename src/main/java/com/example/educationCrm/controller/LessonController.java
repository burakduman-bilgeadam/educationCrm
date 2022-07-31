package com.example.educationCrm.controller;

import com.example.educationCrm.model.dto.LessonDTO;
import com.example.educationCrm.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lesson")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveLesson(@RequestBody LessonDTO lessonDTO) {
        this.lessonService.save(lessonDTO.getName());
    }

}
