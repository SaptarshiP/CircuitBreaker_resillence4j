package com.psja.ressilanceTest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

@Service
public class ApplicationService {

		
	@Autowired
	private RestTemplate restTemplate;
	
	@CircuitBreaker( fallbackMethod="testFallBackMethod", name = "TEST_FALLBACK_METHOD" )
	public void getData() {
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity httpEntity = new HttpEntity( httpHeaders );
		
		restTemplate.exchange("http://test.com", HttpMethod.GET, httpEntity, String.class);
	}
	
	public void testFallBackMethod(Exception exp) {
		System.out.println( "In fallback method" );
	}
	
}
