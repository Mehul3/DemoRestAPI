package com.firstporject.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	
	@GetMapping("api/controller")
	public String sayhello() {
		
		return "hello from spring";
	}
	
	
	

}
