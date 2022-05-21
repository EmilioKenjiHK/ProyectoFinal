package com.example.ProyectoFinal.controller;

import com.example.ProyectoFinal.model.ShopTable;
import com.example.ProyectoFinal.service.ShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class ShopController {

    @Autowired
    private ShopService shopService;

    // Devices
    @GetMapping("/shop")
    public ResponseEntity<Iterable<ShopTable>> getShopItems() {

        var elements = shopService.getShopItems();

        return ResponseEntity.ok().body(elements);
    }
}
