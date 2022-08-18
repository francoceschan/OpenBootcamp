package com.ob.ejercicio1.controller;

import com.ob.ejercicio1.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:8080");
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/laptop", Laptop[].class);
        List<Laptop> laptops = Arrays.asList(response.getBody());

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertNotEquals(0,laptops.size());
    }

    @Test
    void findOneById() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/laptop/2", Laptop.class);


        assertEquals(HttpStatus.OK,response.getStatusCode());

        System.out.println(response.getBody().getModelo());
        assertNotNull(response.getBody().getModelo());

    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                "marca":"Marca TEST",
                "modelo":"Modelo TEST",
                "procesador":"Intel i5 11va",
                "ram":8,
                "almacenamiento":256,
                "tamanioPantalla":15.6
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/laptop",HttpMethod.POST,request, Laptop.class);

        System.out.println(response.getBody().getMarca());
        assertEquals("Marca TEST",response.getBody().getMarca());
    }

    @Test
    void update() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                "id":1,
                "marca":"Marca UPDATE TEST",
                "modelo":"Modelo UPDATE TEST",
                "procesador":"Intel i5 11va",
                "ram":8,
                "almacenamiento":256,
                "tamanioPantalla":15.6
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/laptop",HttpMethod.PUT,request, Laptop.class);

        System.out.println(response.getBody().getMarca());
        assertEquals("Marca UPDATE TEST",response.getBody().getMarca());
    }

    @Test
    void delete() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/laptop/1",HttpMethod.DELETE,request, Laptop.class);

        assertNull(response.getBody());
    }

    @Test
    void deleteAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/laptop",HttpMethod.DELETE,request, Laptop.class);

        assertNull(response.getBody());
    }
}