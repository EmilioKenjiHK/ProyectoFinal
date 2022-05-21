package com.example.ProyectoFinal.service;

import com.example.ProyectoFinal.model.ShopTable;

public interface ShopService {

    // All data from TIENDA table
    Iterable<ShopTable> getShopItems();
    
}
