package com.example.ProyectoFinal.controller;

import com.example.ProyectoFinal.model.UserTable;
import com.example.ProyectoFinal.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    // Devices
    @GetMapping("/users")
    public ResponseEntity<Iterable<UserTable>> getUsers() {

        var elements = userService.getUsers();

        return ResponseEntity.ok().body(elements);
    }
}
