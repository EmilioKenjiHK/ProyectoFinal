package com.example.ProyectoFinal.service;

import java.util.List;

import com.example.ProyectoFinal.model.UserTable;

public interface UserService {

    // All data from USUARIO table
    Iterable<UserTable> getUsers();

    // User data from USUARIO table
    List<UserTable> checkUser(String u, String p);

    // Update User data from USUARIO table
    void updateFeature(String header, String old_f , String new_f);

    // Get Password from USUARIO table
    List<String> getPassword(String u);
}
