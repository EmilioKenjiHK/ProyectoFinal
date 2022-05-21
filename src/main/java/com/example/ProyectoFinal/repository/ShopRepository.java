package com.example.ProyectoFinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ProyectoFinal.model.ShopTable;

@Repository
public interface ShopRepository extends CrudRepository<ShopTable, Long> { }
