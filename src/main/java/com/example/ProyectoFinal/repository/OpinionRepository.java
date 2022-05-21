package com.example.ProyectoFinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ProyectoFinal.model.OpinionTable;

@Repository
public interface OpinionRepository extends CrudRepository<OpinionTable, Long> { }
