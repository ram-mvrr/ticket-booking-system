package com.example.ticketbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class TicketbookingApplication {
	public static void main(String[] args) {
		SpringApplication.run(TicketbookingApplication.class, args);
	}

}
