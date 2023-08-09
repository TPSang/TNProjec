package com.poly.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
/*
 * @RestController
 * 
 * @RequestMapping("/api/admin")
 */
public class BookStoreApplication {
 
	/*
	 * @GetMapping("/apiadmin") public String apiroot() { return "Hello333 "; }
	 */
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

}
