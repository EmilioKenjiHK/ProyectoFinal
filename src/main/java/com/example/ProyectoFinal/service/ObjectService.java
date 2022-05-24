package com.example.ProyectoFinal.service;

import java.util.List;

import com.example.ProyectoFinal.model.ObjectDescTable;
import com.example.ProyectoFinal.model.ObjectTable;

public interface ObjectService {

    // All data from OBJETO table
    Iterable<ObjectTable> getObjects();

    List<ObjectDescTable> getObjectDesc();
}
