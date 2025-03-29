package com.example.eldocuments.feteres.doljnost.services;

import com.example.eldocuments.feteres.doljnost.enitites.DoljnostEntity;

import java.util.List;

public interface DoljnostService {

    List<DoljnostEntity> getAll();

    DoljnostEntity getById(Integer id);

    DoljnostEntity create(String name);
}
