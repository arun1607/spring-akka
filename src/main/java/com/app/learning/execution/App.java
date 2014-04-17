package com.app.learning.execution;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.learning.config.AppConfig;
import com.app.learning.service.PersonService;

public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				AppConfig.class);

		PersonService personService = ctx.getBean(PersonService.class);

	}
}
