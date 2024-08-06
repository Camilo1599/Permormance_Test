package com.riwi.entities;

import com.riwi.persistences.util.enums.studentStatus;

public class StudentsEntity {
    private Integer id;
    private String name;
    private String lastname;
    private String email;
    private String document;
    private studentStatus status;

    public StudentsEntity(){}

    public StudentsEntity(int id, String name, String lastname, String email, String document, studentStatus status) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.document = document;
        this.status = status;
    }

    public int getId() {
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public studentStatus getStatus() {
        return status;
    }

    public void setStatus(studentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", document='" + document + '\'' +
                ", status=" + status +
                '}';
    }
}
