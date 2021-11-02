//@Author Christian Dummer
package main;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import controller.Controller;
import model.Model;
import parsetext.FillerWordsUtility;
import speechtotext.Speech;
 
public class Main {

	//Currently demoing in main, the front end will take input to make these calls in the future
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Model model = new Model();
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
		
		
	}

}
