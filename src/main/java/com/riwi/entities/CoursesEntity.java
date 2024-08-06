package com.riwi.entities;

public class CoursesEntity {
    private Integer id;
    private String name;
    private Integer number_student;

    public CoursesEntity(){}

    public CoursesEntity(Integer id, String name, Integer number_student) {
        this.id = id;
        this.name = name;
        this.number_student = number_student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber_student() {
        return number_student;
    }

    public void setNumber_student(Integer number_student) {
        this.number_student = number_student;
    }

    @Override
    public String toString() {
        return "CoursesEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number_student=" + number_student +
                '}';
    }
}
