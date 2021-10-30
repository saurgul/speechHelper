//@Author Christian Dummer
package main;

import java.io.File;
import java.net.URISyntaxException;

import controller.Controller;
import model.Model;
import speechtotext.Speech;
import speechtotext.SpeechToTextCommand;
 
public class Main {

	//Default spring setup 
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Model model = new Model();
		Controller controller = new Controller(model);
		
		//Example speech to text command and execution.
		File audioFilePath;
		try {
			audioFilePath = new File(Main.class.getClassLoader().getResource("test.wav").toURI());
			controller.speechToText(audioFilePath);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		//Temporary hacky way of getting newest Speech object from model
		Speech newSpeech = model.getSpeeches().get(model.getSpeeches().size() - 1);
		controller.generateReport(newSpeech);
		
	}

}
