package com.example.ProyectoFinal.service;

import com.example.ProyectoFinal.model.ObjectTable;

public interface ObjectService {

    // All data from OBJETO table
    Iterable<ObjectTable> getObjects();
    
}
