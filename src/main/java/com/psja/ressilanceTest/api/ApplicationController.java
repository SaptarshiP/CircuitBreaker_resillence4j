package com.psja.ressilanceTest.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.psja.ressilanceTest.service.ApplicationService;

@RestController
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;
	
		
	@RequestMapping(value="/getData")
	public String getData() {
		applicationService.getData();
		return null;
	}
		
}
