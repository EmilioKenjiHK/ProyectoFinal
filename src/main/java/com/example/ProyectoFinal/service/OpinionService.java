package com.example.ProyectoFinal.service;

import com.example.ProyectoFinal.model.OpinionTable;

public interface OpinionService {

    // All data from OPINION table
    Iterable<OpinionTable> getOpinions();

    // Add opinion to OBJETO table
    void addOpinion(Long id, String texto);
    
}
