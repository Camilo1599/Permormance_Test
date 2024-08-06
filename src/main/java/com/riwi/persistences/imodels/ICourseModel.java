package com.riwi.persistences.imodels;

import com.riwi.entities.CoursesEntity;
import com.riwi.entities.StudentsEntity;
import com.riwi.persistences.crud.CreateModel;
import com.riwi.persistences.crud.DeleteModel;
import com.riwi.persistences.crud.ReadAllModel;
import com.riwi.persistences.crud.UpdateModel;

public interface ICourseModel extends
        CreateModel<CoursesEntity>,
        ReadAllModel<CoursesEntity>,
        UpdateModel<CoursesEntity>,
        DeleteModel<Integer> {
}

