package com.app.learning.execution;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.learning.config.AppConfig;
import com.app.learning.model.Plane;
import com.app.learning.service.PlaneService;

public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				AppConfig.class);

		Plane plane = new Plane();
		plane.setName("Airbus");
		PlaneService planeService = ctx.getBean(PlaneService.class);
		planeService.save(plane);

		plane.setName("Mac");
	}
}
