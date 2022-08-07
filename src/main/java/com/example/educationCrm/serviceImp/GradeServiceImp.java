package com.example.educationCrm.serviceImp;

import com.example.educationCrm.helper.ModelMapperHelper;
import com.example.educationCrm.model.dto.GradeDTO;
import com.example.educationCrm.model.entity.Grade;
import com.example.educationCrm.model.entity.Student;
import com.example.educationCrm.model.entity.Teacher;
import com.example.educationCrm.repository.GradeRepository;
import com.example.educationCrm.repository.StudentRepository;
import com.example.educationCrm.repository.TeacherRepository;
import com.example.educationCrm.service.GradeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImp implements GradeService {
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ModelMapperHelper modelMapperHelper;

    @Transactional
    @Override
    public void update(GradeDTO gradeDTO) {
        Optional<Grade> gradeOptional =
                this.gradeRepository.findById(gradeDTO.getId());
        if(gradeOptional.isPresent()){
            Grade grade = gradeOptional.get();
            grade.setGrade(gradeDTO.getGrade());
            Student student =
                    this.studentRepository
                            .findById(gradeDTO.getStudentId())
                            .orElse(null);
            grade.setStudent(student);
            Teacher teacher =
                    this.teacherRepository
                            .findById(gradeDTO.getTeacherId())
                            .orElse(null);
            grade.setTeacher(teacher);
            this.gradeRepository.save(grade);
        }

    }

    @Transactional
    @Override
    public void save(GradeDTO gradeDTO) {
        Grade grade = new Grade();
        grade.setGrade(gradeDTO.getGrade());
        Student student =
                this.studentRepository
                        .findById(gradeDTO.getStudentId())
                        .orElse(null);
        grade.setStudent(student);
        Teacher teacher =
                this.teacherRepository
                        .findById(gradeDTO.getTeacherId())
                        .orElse(null);
        grade.setTeacher(teacher);
        this.gradeRepository.save(grade);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        this.gradeRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<GradeDTO> findAll() {
        return modelMapperHelper.mapAll(
                (List<Grade>)this.gradeRepository.findAll()
                ,GradeDTO.class);
    }
}
