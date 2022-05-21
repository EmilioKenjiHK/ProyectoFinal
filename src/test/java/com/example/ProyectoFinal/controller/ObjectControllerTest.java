package com.example.ProyectoFinal.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.ProyectoFinal.model.ObjectTable;
import com.example.ProyectoFinal.repository.ObjectRepository;

import static org.assertj.core.api.BDDAssertions.then;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ObjectControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectRepository objectRepository;

    public static Logger logger = LoggerFactory.getLogger(ObjectControllerTest.class);

    @Test
    public void given_endpoint_teams_in_object_when_call_then_Ok() {

        //Given
        String address = "http://localhost:" + port + "/api/v1/objects";
        Iterable<ObjectTable> expectedResponse = objectRepository.findAll();

        logger.info("Given Cumplido");

        //When
        ResponseEntity<Iterable<ObjectTable>> result =
                restTemplate.exchange(
                        address,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        }
                );

        //Then
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(expectedResponse);
    }

}
