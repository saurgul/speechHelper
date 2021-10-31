//@Author Christian Dummer
package controller;

import java.io.File;

import command.Command;
import model.Model;
import parsetext.ParseSpeechTextCommand;
import parsetext.WordCountUtility;
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
	
	public void parseText(Speech speech) {
		ParseSpeechTextCommand parseTextCommand = new ParseSpeechTextCommand(model, speech);
		model.receiveCommand(parseTextCommand);
		parseTextCommand.getWordFreqeucnyCount().toString();
		System.out.println(parseTextCommand.getFillerFreqeucny().toString());
	}
}
