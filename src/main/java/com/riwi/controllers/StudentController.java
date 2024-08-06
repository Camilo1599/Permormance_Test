package com.riwi.controllers;

import com.riwi.entities.StudentsEntity;
import com.riwi.models.StudentModelImp;
import com.riwi.persistences.imodels.IStudentModel;

import java.util.List;

public class StudentController {
    IStudentModel studentModel = new StudentModelImp();

    public StudentsEntity create(StudentsEntity studentEntity) {
        return this.studentModel.create(studentEntity);
    }

    public List<StudentsEntity> readAll() {
        return this.studentModel.readAll();
    }

    public void update(Integer id, StudentsEntity studentEntity) {
        this.studentModel.update(id, studentEntity);
    }

}
