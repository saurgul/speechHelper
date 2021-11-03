//@Author Christian Dummer
package com.speechhelper.main;

import java.io.File;
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
		Model model = new Model();
		SpeakingHelperController controller = new SpeakingHelperController(model);
		SpringApplication.run(Main.class, args);
		
		/*Model model = new Model();
		Controller controller = new Controller(model);
		
		//Accessing an audiofile from resources
		File audioFilePath;
		try {
			audioFilePath = new File(Main.class.getClassLoader().getResource("demo.wav").toURI());
			
			//Asking controller to make a speech to text Command
			//controller.speechToText(audioFilePath);
		
			//Creates a speech from the content of the URL and passes it to the model (using temp url)
			controller.createSpeech("https://raw.githubusercontent.com/pratu13/ToDoApp/main/README.md");

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
