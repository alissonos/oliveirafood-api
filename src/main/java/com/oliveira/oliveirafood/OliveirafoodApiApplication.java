package com.oliveira.oliveirafood;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@SpringBootApplication
public class OliveirafoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OliveirafoodApiApplication.class, args);
	}

}
