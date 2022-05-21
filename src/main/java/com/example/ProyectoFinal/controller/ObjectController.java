package com.example.ProyectoFinal.controller;

import com.example.ProyectoFinal.model.ObjectTable;
import com.example.ProyectoFinal.service.ObjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class ObjectController {

    @Autowired
    private ObjectService objectService;

    // Devices
    @GetMapping("/objects")
    public ResponseEntity<Iterable<ObjectTable>> getObjects() {

        var elements = objectService.getObjects();

        return ResponseEntity.ok().body(elements);
    }
}
