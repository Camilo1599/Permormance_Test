package com.riwi.controllers;

import com.riwi.entities.CoursesEntity;
import com.riwi.models.CourseModelImp;
import com.riwi.persistences.imodels.ICourseModel;

import java.util.List;

public class CourseController {
    ICourseModel courseModel = new CourseModelImp();

    public CoursesEntity create(CoursesEntity courseEntity) {
        return this.courseModel.create(courseEntity);
    }

    public List<CoursesEntity> readAll() {
        return this.courseModel.readAll();
    }

    public void update(Integer id, CoursesEntity courseEntity) {
        this.courseModel.update(id, courseEntity);
    }

    public void delete(Integer id){
        this.courseModel.delete(id);
    }
}
