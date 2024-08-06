package com.riwi.persistences.imodels;

import com.riwi.entities.StudentsEntity;
import com.riwi.persistences.crud.CreateModel;
import com.riwi.persistences.crud.DeleteModel;
import com.riwi.persistences.crud.ReadAllModel;
import com.riwi.persistences.crud.UpdateModel;

public interface IStudentModel extends
        CreateModel<StudentsEntity>,
        ReadAllModel<StudentsEntity>,
        UpdateModel<StudentsEntity>{
}
