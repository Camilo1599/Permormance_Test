package com.riwi.persistences.crud;

import java.util.List;

public interface ReadAllModel <Entity>{
    List<Entity> readAll();
}