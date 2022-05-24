package com.example.ProyectoFinal.controller;

import java.util.List;

import com.example.ProyectoFinal.model.UserTable;
import com.example.ProyectoFinal.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api/v1")
public class UserController {

    public static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Iterable<UserTable>> getUsers() {

        var elements = userService.getUsers();

        return ResponseEntity.ok().body(elements);
    }

    @GetMapping("/users/check")
    public ResponseEntity<List<UserTable>> checkUser( @RequestParam String u_username, @RequestParam String u_password) {

        logger.info("Hola");

        var elements = userService.checkUser(u_username, u_password);

        return ResponseEntity.ok().body(elements);
    }

    @GetMapping("/users/backup")
    public ResponseEntity<List<String>> checkUser( @RequestParam String u_username) {

        logger.info("Hola");

        var elements = userService.getPassword(u_username);

        return ResponseEntity.ok().body(elements);
    }

    @PutMapping("/users")
    public void updateHeader(@RequestBody String s) {
        //logger.info("Respuesta: " + header + " " + feature);

        String header2 = "";
        logger.info(s.split(",")[0]);
        switch(s.split(",")[0]) {
            case "u_username":
            header2 = "NOMBRE_USUARIO";
            break;

            case "u_password":
            header2 = "CONTRASENYA";
            break;

            case "u_email":
            header2 = "CORREO";
            break;
        }

        logger.info(header2);
        logger.info(s.split(",")[1]);
        logger.info(s.split(",")[2]);
        userService.updateFeature(header2, s.split(",")[1], s.split(",")[2]);
    }
}
