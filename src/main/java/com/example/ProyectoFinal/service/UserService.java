package com.example.ProyectoFinal.service;

import com.example.ProyectoFinal.model.UserTable;

public interface UserService {

    // All data from USUARIO table
    Iterable<UserTable> getUsers();
    
}
