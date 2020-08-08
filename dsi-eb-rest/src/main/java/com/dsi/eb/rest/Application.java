package com.dsi.eb.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author rjaforever
 *
 */
@SpringBootApplication
@ComponentScan("com.dsi.eb")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
