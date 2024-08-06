package com.riwi.persistences.imodels;

import com.riwi.entities.GradesEntity;
import com.riwi.entities.StudentsEntity;
import com.riwi.persistences.crud.CreateModel;
import com.riwi.persistences.crud.ReadAllModel;
import com.riwi.persistences.crud.UpdateModel;

public interface IGradeModel extends
        CreateModel<GradesEntity>,
        ReadAllModel<GradesEntity>,
        UpdateModel<GradesEntity> {
}
