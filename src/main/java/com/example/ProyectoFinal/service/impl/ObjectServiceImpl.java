package com.example.ProyectoFinal.service.impl;

import com.example.ProyectoFinal.model.ObjectTable;
import com.example.ProyectoFinal.repository.ObjectRepository;
import com.example.ProyectoFinal.service.ObjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectServiceImpl implements ObjectService {

    @Autowired
    private ObjectRepository objectRepository;


    @Override
    public Iterable<ObjectTable> getObjects() {
        return objectRepository.findAll();
    }

}
