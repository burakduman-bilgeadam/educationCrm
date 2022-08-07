package com.example.educationCrm.serviceImp;

import com.example.educationCrm.model.dto.SchoolDTO;
import com.example.educationCrm.model.dto.SchoolInformationDTO;
import com.example.educationCrm.model.entity.School;
import com.example.educationCrm.repository.SchoolRepository;
import com.example.educationCrm.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImp implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Transactional
    @Override
    public void save(String name) {
        School school = new School(name);
        this.schoolRepository.save(school);
    }

    @Transactional
    @Override
    public void update(SchoolDTO schoolDTO) {
       Optional<School> schoolOptional=
               this.schoolRepository.findById(schoolDTO.getId());
       if(schoolOptional.isPresent()){
           School school = schoolOptional.get();
           school.setName(schoolDTO.getName());
           this.schoolRepository.save(school);
       }
    }

    @Transactional
    @Override
    public void delete(SchoolDTO schoolDTO) {
        this.schoolRepository.deleteById(schoolDTO.getId());
    }

    @Transactional(readOnly = true)
    @Override
    public List<SchoolInformationDTO> findAllName() {
        return this.schoolRepository.getSchoolBy();
    }
}
