package com.siddharth.helios;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class HeliosApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeliosApplication.class, args);
	}

}
