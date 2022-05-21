package com.example.ProyectoFinal.controller;

import com.example.ProyectoFinal.model.PurchaseTable;
import com.example.ProyectoFinal.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    // Devices
    @GetMapping("/purchases")
    public ResponseEntity<Iterable<PurchaseTable>> getPurchases() {

        var elements = purchaseService.getPurchases();

        return ResponseEntity.ok().body(elements);
    }
}
