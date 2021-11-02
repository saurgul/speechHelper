//@Author Christian Dummer
package com.speechhelper.main;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.speechhelper.controller.SpeakingHelperController;
import com.speechhelper.model.Model;
import com.speechhelper.parsetext.FillerWordsUtility;
import com.speechhelper.speechtotext.Speech;


@SpringBootApplication
@ComponentScan(basePackageClasses = SpeakingHelperController.class)
public class Main {

	//Currently demoing in main, the front end will take input to make these calls in the future
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		
		/*Model model = new Model();
		Controller controller = new Controller(model);
		
		//Accessing an audiofile from resources
		File audioFilePath;
		try {
			audioFilePath = new File(Main.class.getClassLoader().getResource("demo.wav").toURI());
			
			//Asking controller to make a speech to text Command
			controller.speechToText(audioFilePath);
			
			//Temporary normally these would be called by UI referencing a controller method
			Speech newSpeech = model.getSpeeches().get(model.getSpeeches().size() - 1);
			
			//Creates a parseText command and passes it to the model
			controller.parseText(newSpeech);
			
			//Creates a generate report command and passes it to the model
			controller.generateReport(newSpeech);	
			
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		*/
		
	}

}
