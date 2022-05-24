package com.example.ProyectoFinal.controller;

import com.example.ProyectoFinal.model.OpinionTable;
import com.example.ProyectoFinal.service.OpinionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class OpinionController {

    @Autowired
    private OpinionService opinionService;

    @GetMapping("/opinions")
    public ResponseEntity<Iterable<OpinionTable>> getOpinions() {

        var elements = opinionService.getOpinions();

        return ResponseEntity.ok().body(elements);
    }

    @PostMapping("/opinions")
    public void newOpinion(@RequestBody OpinionTable opinion) {
        opinionService.addOpinion(opinion.getOp_id(), opinion.getOp_text());;
    }
}
