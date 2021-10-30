package controller;

import java.io.File;

import command.Command;
import model.Model;
import speechtotext.SpeechToTextCommand;

public class Controller {
	private Model model;
	
	public Controller() {
		
	}
	
	public Controller(Model m) {
		this.model = m;
	}
	
	//Performs speech to text command
	public void speechToText(File f) {
		Command speechToTextCommand = new SpeechToTextCommand(model);
		model.receiveCommand(speechToTextCommand);
	}
}
