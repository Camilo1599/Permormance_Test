package com.riwi.entities;

public class RegistrationsEntity {
    private Integer id;
    private Integer course_id;
    private Integer student_id;

    public RegistrationsEntity(){}

    public RegistrationsEntity(Integer id, Integer course_id, Integer student_id) {
        this.id = id;
        this.course_id = course_id;
        this.student_id = student_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "registrations{" +
                "id=" + id +
                ", course_id=" + course_id +
                ", student_id=" + student_id +
                '}';
    }
}
