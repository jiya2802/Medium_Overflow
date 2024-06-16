package com.sgt.mediumoverflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MediumOverflowApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext=
		SpringApplication.run(MediumOverflowApplication.class, args);

//		Car c=applicationContext.getBean(Car.class);
//		c.startCar();
	}

}
