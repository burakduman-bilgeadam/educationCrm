package com.example.educationCrm.model.entity;

import javax.persistence.*;

@Entity
public class Grade extends BaseEntity{

    private Double grade;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Teacher teacher;

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
