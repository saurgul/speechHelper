//@Author Christian Dummer
package com.speechhelper.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.speechhelper.controller.SpeakingHelperController;


@SpringBootApplication
@ComponentScan(basePackageClasses = SpeakingHelperController.class)
public class Main {

	//Currently demoing in main, the front end will take input to make these calls in the future
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
