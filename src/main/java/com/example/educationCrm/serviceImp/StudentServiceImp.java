package com.example.educationCrm.serviceImp;

import com.example.educationCrm.model.dto.StudentDTO;
import com.example.educationCrm.model.entity.School;
import com.example.educationCrm.model.entity.Student;
import com.example.educationCrm.model.entity.StudentClass;
import com.example.educationCrm.repository.SchoolRepository;
import com.example.educationCrm.repository.StudentClassRepository;
import com.example.educationCrm.repository.StudentRepository;
import com.example.educationCrm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private StudentClassRepository studentClassRepository;
    private final SimpleDateFormat formatter
            = new SimpleDateFormat("dd-MM-yyyy"
            , Locale.ENGLISH);

    @Transactional
    @Override
    public void save(StudentDTO studentDto) throws ParseException {
        Student student = new Student();
        student.setBirthDate(
                formatter.parse(studentDto.getBirthDate()));
        student.setNumber(studentDto.getNumber());
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setCreatedDate(formatter
                .parse(studentDto.getCreatedDate()));
        StudentClass studentClass = this.studentClassRepository
                .findById(studentDto.getStudentClassId())
                .orElse(null);
        School school = this.schoolRepository
                .findById(studentDto.getSchoolId())
                .orElse(null);
        student.setSchool(school);
        student.setStudentClass(studentClass);
        this.studentRepository.save(student);
    }
}
