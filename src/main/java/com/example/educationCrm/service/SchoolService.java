package com.example.educationCrm.service;

import com.example.educationCrm.model.dto.SchoolDTO;
import com.example.educationCrm.model.dto.SchoolInformationDTO;

import java.util.List;

public interface SchoolService {
    public void save(String name);
    public void update(SchoolDTO schoolDTO);
    public void delete(SchoolDTO schoolDTO);

    public List<SchoolInformationDTO> findAllName();

}
