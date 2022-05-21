package com.example.ProyectoFinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ProyectoFinal.model.ObjectTable;

@Repository
public interface ObjectRepository extends CrudRepository<ObjectTable, Long> { }
