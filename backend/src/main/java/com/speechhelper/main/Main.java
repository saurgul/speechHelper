//@Author Christian Dummer
package com.speechhelper.main;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.speechhelper.controller.SpeakingHelperController;


@SpringBootApplication
@ComponentScan(basePackageClasses = SpeakingHelperController.class)
public class Main {

	//Currently demoing in main, the front end will take input to make these calls in the future
	public static void main(String[] args) {
		//SpringApplication.run(Main.class, args);
		SpringApplication app = new SpringApplication(Main.class);
//		//SpringApplication.run(Main.class, args);
		app.setDefaultProperties(Collections
		          .singletonMap("server.port", "8089"));
		app.run(args);
	}

}
