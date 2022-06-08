package com.soses.hris;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrisApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(HrisApplication.class);
	private static final org.apache.logging.log4j.Logger log4 = LogManager.getLogger(HrisApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HrisApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		log.error("START COMPLETED");
	}
}
