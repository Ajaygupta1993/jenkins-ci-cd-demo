package com.agtech.jenkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinsPipeLineApplication {
	
	@GetMapping("/greetings/{name}")
	public String greetings(@PathVariable String name) {
		
		return "Hello " + name +  "Congrats successfully deployed in CI CD";
	}

	public static void main(String[] args) {
		SpringApplication.run(JenkinsPipeLineApplication.class, args);
	}

}
