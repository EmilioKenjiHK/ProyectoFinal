package com.example.ProyectoFinal.service.impl;

import com.example.ProyectoFinal.model.ShopTable;
import com.example.ProyectoFinal.repository.ShopRepository;
import com.example.ProyectoFinal.service.ShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;


    @Override
    public Iterable<ShopTable> getShopItems() {
        return shopRepository.findAll();
    }

}
