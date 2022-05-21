package com.example.ProyectoFinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ProyectoFinal.model.UserTable;

@Repository
public interface UserRepository extends CrudRepository<UserTable, Long> { }
