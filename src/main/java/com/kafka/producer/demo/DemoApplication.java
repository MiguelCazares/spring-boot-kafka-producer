package com.kafka.producer.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
		logger.info("Aplicación iniciada");

		Producer producer = Producer.getInstance();

		producer.send("Hello World", "mensaje de prueba 4");
		producer.close();
	}

}
