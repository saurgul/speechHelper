//@Author Christian Dummer
package controller;

import java.io.File;
import command.Command;
import model.Model;
import parsetext.ParseSpeechTextCommand;
import speechtotext.CreateSpeechCommand;
import speechtotext.GenerateReportCommand;
import speechtotext.ModifySpeechCommand;
import speechtotext.Speech;
import speechtotext.SpeechToTextCommand;


public class Controller {
	private Model model;
	
	public Controller() {
		
	}
	
	public Controller(Model m) {
		this.model = m;
	}
	
	//Create a speech from the downloaded file Content
	public void createSpeech(String urlString) {
		Command createSpeechCommand = new CreateSpeechCommand(model, urlString);
		model.receiveCommand(createSpeechCommand);
	}
	
	//Performs speech to text command
	public void speechToText(File file) {
		Command speechToTextCommand = new SpeechToTextCommand(model, file);
		model.receiveCommand(speechToTextCommand);
	}
	
	//Generates feedback report on given speech object
	public void generateReport(Speech speech) {
		Command generateReportCommand = new GenerateReportCommand(model, speech);
		model.receiveCommand(generateReportCommand);
	}
	
	//Modifies the stored speech object
	public void modifySpeech(Speech speech) {
		Command modifySpeechCommand = new ModifySpeechCommand(model, speech);
		model.receiveCommand(modifySpeechCommand);
	}
	
	//Performs content analyzer command
	public void parseText(Speech speech) {
		ParseSpeechTextCommand parseTextCommand = new ParseSpeechTextCommand(model, speech);
		model.receiveCommand(parseTextCommand);
		System.out.println(parseTextCommand.getWordFrequencyCount().toString());
		System.out.println(parseTextCommand.getFillerFrequency().toString());
		System.out.printf("%.2f percent of content text in speech is filler",parseTextCommand.getFillerPercentage());
	}
}
