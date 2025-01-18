package com.example.linkedIN;

import com.example.linkedIN.DataBase.DBSetup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LinkedInApplication {

	public static void main(String[] args) {
		DBSetup.setup();
		SpringApplication.run(LinkedInApplication.class, args);
	}

}
