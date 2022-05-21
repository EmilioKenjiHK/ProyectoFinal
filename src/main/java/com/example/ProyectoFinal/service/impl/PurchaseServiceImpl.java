package com.example.ProyectoFinal.service.impl;

import com.example.ProyectoFinal.model.PurchaseTable;
import com.example.ProyectoFinal.repository.PurchaseRepository;
import com.example.ProyectoFinal.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;


    @Override
    public Iterable<PurchaseTable> getPurchases() {
        return purchaseRepository.findAll();
    }

}
