package com.riwi.controllers;

import com.riwi.entities.RegistrationsEntity;
import com.riwi.models.RegistrationModelImp;
import com.riwi.persistences.imodels.IRegistrationModel;

import java.util.List;

public class ResgistrationController {
    IRegistrationModel registrationModel = new RegistrationModelImp();

    public RegistrationsEntity create(RegistrationsEntity registrationEntity) {
        return this.registrationModel.create(registrationEntity);
    }

    public List<RegistrationsEntity> readAll() {
        return this.registrationModel.readAll();
    }

    public void update(Integer id, RegistrationsEntity registrationEntity) {
        this.registrationModel.update(id, registrationEntity);
    }

    public void delete(Integer id){
        this.registrationModel.delete(id);
    }
}
