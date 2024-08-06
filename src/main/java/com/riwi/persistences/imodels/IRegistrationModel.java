package com.riwi.persistences.imodels;

import com.riwi.entities.RegistrationsEntity;
import com.riwi.persistences.crud.CreateModel;
import com.riwi.persistences.crud.DeleteModel;
import com.riwi.persistences.crud.ReadAllModel;
import com.riwi.persistences.crud.UpdateModel;

public interface IRegistrationModel extends
        CreateModel<RegistrationsEntity>,
        ReadAllModel<RegistrationsEntity>,
        UpdateModel<RegistrationsEntity>,
        DeleteModel<Integer> {

}
