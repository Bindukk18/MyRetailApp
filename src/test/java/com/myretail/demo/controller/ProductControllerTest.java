package com.myretail.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Test class for Product controller
 * The Class ProductControllerTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {

    /** The rest template. */
    RestTemplate restTemplate = new RestTemplate();

    /**
     * Gets the unknown product info.
     *
     * @return the unknown product info
     */
    @Test (expected = Exception.class)
    public void getUnknownProductInfo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper mapper = new ObjectMapper();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        Map<String, String> map = new HashMap<String, String>();

        String url = "http://localhost:8082/products/138604";

        ResponseEntity response = new ResponseEntity(null, headers , HttpStatus.NOT_FOUND);
   
        // Create the HTTP GET request,
        when(restTemplate.getForEntity(url, response.getClass(), map)).thenReturn(response);

        assertEquals(404, response.getStatusCode().value());

        return;
    }

    /**
     * Put known product info.
     */
    @Test (expected = Exception.class)
    public void PutKnownProductInfo() {

        HttpHeaders requestHeaders = new HttpHeaders();
        List<MediaType> mediaTypeList = new ArrayList<MediaType>();
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(mediaTypeList);
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);


        String requestBody = "{\"id\":142555346,\"name\":\"The Big Lebowski (Blu-ray) (Widescreen)\",\"current_price\":{\"value\": 13.49,\"currency_code\":\"USD\"}}";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestBody, requestHeaders);

        String url = "http://localhost:8082/products/{id}";
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", "138604289");

        ResponseEntity responseEntity = new ResponseEntity(null, requestHeaders , HttpStatus.NOT_FOUND);

        // Create the HTTP PUT request,
        when(restTemplate.exchange(url, HttpMethod.PUT, requestEntity, responseEntity.getClass(), map)).thenReturn(responseEntity);
    }

}