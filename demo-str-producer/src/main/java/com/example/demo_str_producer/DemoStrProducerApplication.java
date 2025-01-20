package com.example.demo_str_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class DemoStrProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStrProducerApplication.class, args);
	}

}
