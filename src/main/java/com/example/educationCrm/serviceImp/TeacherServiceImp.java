package com.example.educationCrm.serviceImp;

import com.example.educationCrm.helper.ModelMapperHelper;
import com.example.educationCrm.model.dto.TeacherDTO;
import com.example.educationCrm.model.entity.Lesson;
import com.example.educationCrm.model.entity.School;
import com.example.educationCrm.model.entity.Teacher;
import com.example.educationCrm.repository.LessonRepository;
import com.example.educationCrm.repository.SchoolRepository;
import com.example.educationCrm.repository.TeacherRepository;
import com.example.educationCrm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private ModelMapperHelper modelMapperHelper;

    @Transactional
    @Override
    public void save(TeacherDTO teacherDTO) {
        Teacher teacher = this.modelMapperHelper
                .convertToModel(teacherDTO,Teacher.class);
        School school = this.schoolRepository
                .findById(teacherDTO.getSchool_id())
                .orElse(null);
        Lesson lesson =  this.lessonRepository
                .findById(teacherDTO.getLesson_id())
                .orElse(null);
        teacher.setLesson(lesson);
        teacher.setSchool(school);
        this.teacherRepository.save(teacher);
    }

    @Transactional
    @Override
    public void update(TeacherDTO teacherDTO) {
        Optional<Teacher> teacherOptional =
                this.teacherRepository.findById(teacherDTO.getId());
        if(teacherOptional.isPresent()){
            Teacher teacher = teacherOptional.get();
           // teacher = modelMapperHelper.convertToModel(teacherDTO,Teacher.class);
            teacher.setBirthDate(teacherDTO.getBirthDate());
            teacher.setCreatedDate(teacherDTO.getCreatedDate());
            teacher.setName(teacherDTO.getName());
            teacher.setSurname(teacherDTO.getSurname());
            School school = this.schoolRepository
                    .findById(teacherDTO.getSchool_id())
                    .orElse(null);
            Lesson lesson =  this.lessonRepository
                    .findById(teacherDTO.getLesson_id())
                    .orElse(null);
            teacher.setLesson(lesson);
            teacher.setSchool(school);
            this.teacherRepository.save(teacher);
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        this.teacherRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TeacherDTO> findAll() {
        return this.modelMapperHelper.mapAll(
                this.teacherRepository.findAll()
                ,TeacherDTO.class
        );
    }
}
