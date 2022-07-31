package com.example.educationCrm.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class School extends  BaseEntity{

    private String name;
    @OneToMany(mappedBy = "school")
    private List<Student> students;
    @OneToMany(mappedBy = "school")
    private List<Teacher> teachers;

    public School(){}

    public School(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
