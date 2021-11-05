//@Author Christian Dummer
package com.speechhelper.main;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.speechhelper.controller.SpeakingHelperController;
import com.speechhelper.model.Model;
import com.speechhelper.speechtotext.Speech;


@SpringBootApplication
@ComponentScan(basePackageClasses = SpeakingHelperController.class)
public class Main {
	
	//Currently demoing in main, the front end will take input to make these calls in the future
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Main.class);
		//SpringApplication.run(Main.class, args);
		app.setDefaultProperties(Collections
		          .singletonMap("server.port", "8083"));
		app.run(args);
	}

}
