package com.siddharth.helios;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;

@SpringBootApplication
@EnableScheduling
@EnableKafka
public class HeliosApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeliosApplication.class, args);
	}

}
