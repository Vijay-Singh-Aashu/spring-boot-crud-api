package com.excellence.springbootcrudapisecurity.service;

public interface EmailService {
	void sendEmail(String to, String subject, String content);
}
