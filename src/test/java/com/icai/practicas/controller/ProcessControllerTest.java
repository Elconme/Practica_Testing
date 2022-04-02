package com.icai.practicas.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


import com.icai.practicas.controller.ProcessController.DataRequest;
import com.icai.practicas.controller.ProcessController.DataResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProcessControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void credenciales_ok() {

		//Given
		String address = "http://localhost:" + port + "/api/v1/process-step1";
		DataRequest datos = new DataRequest("Elena Conderana Medem", "51507247N", "676487012");
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(datos, headers);

		//When
		ResponseEntity<DataResponse> result = this.restTemplate.postForEntity(address, request, DataResponse.class);

		//Then
		String expectedResult = "OK";
		DataResponse expectedResponse = new DataResponse(expectedResult);

		then(result.getBody().result()).isEqualTo(expectedResult);
		then(result.getBody()).isEqualTo(expectedResponse);
	}

	@Test
    	public void credenciales_no_ok() {

    		//Given
    		String address = "http://localhost:" + port + "/api/v1/process-step1";
    		DataRequest datos = new DataRequest("Elena Conderana Medem", "51LL7247N", "6764-7012");
    		HttpHeaders headers = new HttpHeaders();
    		HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(datos, headers);

    		//When
    		ResponseEntity<DataResponse> result = this.restTemplate.postForEntity(address, request, DataResponse.class);

    		//Then
    		String expectedResult = "KO";
    		DataResponse expectedResponse = new DataResponse(expectedResult);

    		then(result.getBody().result()).isEqualTo(expectedResult);
    		then(result.getBody()).isEqualTo(expectedResponse);
    	}

    	@Test
        	public void credenciales_legacy_ok() throws Exception{

        		//Given
        		String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
        		MultiValueMap<String, String> datos = new LinkedMultiValueMap<String,String>();
        		datos.add("fullName","Elena Conderana");
        		datos.add("dni","51507247N");
        		datos.add("telefono","676487012");
        		HttpHeaders headers = new HttpHeaders();
        		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(datos, headers);

        		//When
        		ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        		//Then
        		String expectedResult = ResponseHTMLGenerator.message1;

        		then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
                then(result.getBody()).isEqualTo(expectedResult);


        	}

        @Test
            public void credenciales_legacy_no_ok() throws Exception{

                //Given
                String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
                MultiValueMap<String, String> datos = new LinkedMultiValueMap<String,String>();
                datos.add("fullName","Elena Conderana");
                datos.add("dni","5150724");
                datos.add("telefono","676*87012");
                HttpHeaders headers = new HttpHeaders();
                HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(datos, headers);

                //When
                ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

                //Then
                String expectedResult = ResponseHTMLGenerator.message2;

                then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
                then(result.getBody()).isEqualTo(expectedResult);
            }
}