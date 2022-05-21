package com.example.ProyectoFinal.service.impl;

import com.example.ProyectoFinal.model.UserTable;
import com.example.ProyectoFinal.repository.UserRepository;
import com.example.ProyectoFinal.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Iterable<UserTable> getUsers() {
        return userRepository.findAll();
    }

}
