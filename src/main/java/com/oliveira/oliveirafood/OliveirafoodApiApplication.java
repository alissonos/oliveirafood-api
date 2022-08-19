package com.oliveira.oliveirafood;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.oliveira.oliveirafood.infraestructure.repository.CustomJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class OliveirafoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OliveirafoodApiApplication.class, args);
	}

}
