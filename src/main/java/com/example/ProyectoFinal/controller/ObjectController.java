package com.example.ProyectoFinal.controller;

import java.util.List;

import com.example.ProyectoFinal.model.ObjectDescTable;
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

    @GetMapping("/objects")
    public ResponseEntity<Iterable<ObjectTable>> getObjects() {

        var elements = objectService.getObjects();

        return ResponseEntity.ok().body(elements);
    }

    @GetMapping("/objects/list")
    public ResponseEntity<List<ObjectDescTable>> getObjectDesc() {
        //logger.info("Llega aqui");

        var elements = objectService.getObjectDesc();

        return ResponseEntity.ok().body(elements);
    }
}
