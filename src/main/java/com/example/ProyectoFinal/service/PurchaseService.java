package com.example.ProyectoFinal.service;

import com.example.ProyectoFinal.model.PurchaseTable;

public interface PurchaseService {

    // All data from COMPRA table
    Iterable<PurchaseTable> getPurchases();
    
}
