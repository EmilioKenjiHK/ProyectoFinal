package com.example.ProyectoFinal.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.ProyectoFinal.model.OpinionTable;
import com.example.ProyectoFinal.repository.OpinionRepository;

import static org.assertj.core.api.BDDAssertions.then;

import java.net.http.HttpHeaders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OpinionControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private OpinionRepository opinionRepository;

    public static Logger logger = LoggerFactory.getLogger(OpinionControllerTest.class);

    @Test
    public void given_endpoint_teams_in_opinion_when_call_then_Ok() {

        //Given
        String address = "http://localhost:" + port + "/api/v1/opinions";
        Iterable<OpinionTable> expectedResponse = opinionRepository.findAll();

        logger.info("Given Cumplido");

        //When
        ResponseEntity<Iterable<OpinionTable>> result =
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

    @Test
    public void given_endpoint_teams_in_opinion_when_post_then_Ok()
    {
        //Given
        OpinionTable opinion = new OpinionTable();
        opinion.setOp_id(Long.valueOf("4"));
        opinion.setOp_text("Opinion Test");

        String url = "http://localhost:" + port + "/api/v1/opinions";
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        HttpEntity<OpinionTable> entity = new HttpEntity<>(opinion, headers);

        headers.setContentType(MediaType.APPLICATION_JSON);

        //When
        ResponseEntity<String> result = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<String>() {
        });

        //Then
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
