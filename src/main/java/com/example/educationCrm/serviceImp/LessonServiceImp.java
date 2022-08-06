package com.example.educationCrm.serviceImp;

import com.example.educationCrm.helper.ModelMapperHelper;
import com.example.educationCrm.model.dto.LessonDTO;
import com.example.educationCrm.model.entity.Lesson;
import com.example.educationCrm.repository.LessonRepository;
import com.example.educationCrm.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImp implements LessonService {
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private ModelMapperHelper modelMapperHelper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(String name) {
        Lesson lesson = new Lesson(name);
        //Lesson lesson1 = new Lesson(name);
        this.lessonRepository.save(lesson);
        //this.lessonRepository.save(lesson1);
    }

    @Transactional
    @Override
    public void update(LessonDTO lessonDTO) {
        Optional<Lesson> lessonOptional =
                this.lessonRepository.findById(lessonDTO.getId());
        if(lessonOptional.isPresent()){
            Lesson lesson= lessonOptional.get();
            lesson.setName(lessonDTO.getName());
            this.lessonRepository.save(lesson);
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        this.lessonRepository.deleteById(id);
    }

    @Override
    public List<LessonDTO> findAll() {
        return modelMapperHelper.mapAll(
                (List<Lesson>)this.lessonRepository.findAll()
                ,LessonDTO.class);
    }
}
