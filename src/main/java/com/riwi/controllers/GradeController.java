package com.riwi.controllers;

import com.riwi.entities.GradesEntity;
import com.riwi.entities.StudentsEntity;
import com.riwi.models.GradeModelImp;
import com.riwi.models.StudentModelImp;
import com.riwi.persistences.imodels.IGradeModel;
import com.riwi.persistences.imodels.IStudentModel;

import java.util.List;

public class GradeController {
    IGradeModel gradeModel = new GradeModelImp();

    public GradesEntity create(GradesEntity gradeEntity) {
        return this.gradeModel.create(gradeEntity);
    }

    public List<GradesEntity> readAll() {
        return this.gradeModel.readAll();
    }

    public void update(Integer id, GradesEntity gardeEntity) {
        this.gradeModel.update(id, gardeEntity);
    }
}
