//@Author Christian Dummer
package com.speechhelper.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.speechhelper.controller.SpeakingHelperController;


@SpringBootApplication
@ComponentScan("com.speechhelper")
@EntityScan("com.speechhelper")
@EnableJpaRepositories("com.speechhelper")
public class Main {
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
