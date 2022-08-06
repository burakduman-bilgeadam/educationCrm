package com.example.educationCrm.serviceImp;

import com.example.educationCrm.model.entity.Lesson;
import com.example.educationCrm.repository.LessonRepository;
import com.example.educationCrm.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLDataException;

@Service
public class LessonServiceImp implements LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(String name) {
        Lesson lesson = new Lesson(name);
        //Lesson lesson1 = new Lesson(name);
        this.lessonRepository.save(lesson);
        //this.lessonRepository.save(lesson1);
    }
}
