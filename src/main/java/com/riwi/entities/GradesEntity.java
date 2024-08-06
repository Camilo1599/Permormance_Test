package com.riwi.entities;

import com.riwi.persistences.util.enums.gradeType;

public class GradesEntity {
    private Integer id;
    private Double grade;
    private gradeType grade_type;
    private Integer registration_id;

    public GradesEntity(){}
    public GradesEntity(Integer id, Double grade, gradeType grade_type, Integer registration_id) {
        this.id = id;
        this.grade = grade;
        this.grade_type = grade_type;
        this.registration_id = registration_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public gradeType getGrade_type() {
        return grade_type;
    }

    public void setGrade_type(gradeType grade_type) {
        this.grade_type = grade_type;
    }

    public Integer getRegistration_id() {
        return registration_id;
    }

    public void setRegistration_id(Integer registration_id) {
        this.registration_id = registration_id;
    }

    @Override
    public String toString() {
        return "grades{" +
                "id=" + id +
                ", grade=" + grade +
                ", grade_type=" + grade_type +
                ", registration_id=" + registration_id +
                '}';
    }
}


