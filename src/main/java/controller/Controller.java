//@Author Christian Dummer
package controller;

import java.io.File;

import command.Command;
import model.Model;
import speechtotext.GenerateReportCommand;
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
}
