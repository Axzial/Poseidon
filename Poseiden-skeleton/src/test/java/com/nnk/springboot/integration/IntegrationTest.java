package com.nnk.springboot.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.net.URI;

public abstract class IntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    public void testStatus(HttpMethod method, URI uri, HttpStatus shouldReturn) {
        webTestClient.method(method).uri(uri).exchange().expectStatus().isEqualTo(shouldReturn);
    }

    public void testStatus(HttpMethod method, URI uri, String jwt, HttpStatus shouldReturn) {
        webTestClient.method(method)
                .uri(uri)
                .header("Authorization", "Bearer " + jwt)
                .exchange()
                .expectStatus()
                .isEqualTo(shouldReturn);
    }
}
