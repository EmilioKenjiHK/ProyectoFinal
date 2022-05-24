package com.example.ProyectoFinal.service.impl;

import com.example.ProyectoFinal.model.OpinionTable;
import com.example.ProyectoFinal.repository.OpinionRepository;
import com.example.ProyectoFinal.service.OpinionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class OpinionServiceImpl implements OpinionService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OpinionRepository opinionRepository;


    @Override
    public Iterable<OpinionTable> getOpinions() {
        return opinionRepository.findAll();
    }

    @Override
    public void addOpinion(Long id, String text) {
        jdbcTemplate.update("INSERT INTO OPINION (OPINION_ID,TEXTO) VALUES (?, ?)",
        id,text);
    }

}
