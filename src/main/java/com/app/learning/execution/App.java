package com.app.learning.execution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.app.learning")
@EnableJpaRepositories("com.app.learning.repository")
@EnableAutoConfiguration
@EntityScan(basePackages = "com.app.learning.model")
public class App {

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}

}
