package com.example.ProyectoFinal.repository;

import com.example.ProyectoFinal.model.PurchaseTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<PurchaseTable, Long> { }
