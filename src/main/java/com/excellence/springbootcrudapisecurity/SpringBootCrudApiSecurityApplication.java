package com.excellence.springbootcrudapisecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.event.EventListener;

import com.excellence.springbootcrudapisecurity.service.EmailSenderService;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class SpringBootCrudApiSecurityApplication {
	
	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApiSecurityApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		senderService.sendSimpleEmail("vijaysinghaashu@gmail.com",
				"This is email body",
				"This is email subject");

	}

}
