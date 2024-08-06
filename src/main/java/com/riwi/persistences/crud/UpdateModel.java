package com.riwi.persistences.crud;


public interface UpdateModel <Entity>{
    void update(Integer id, Entity entity);
}