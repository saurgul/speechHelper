//@Author Christian Dummer
package com.speechhelper.controller;

import java.io.File;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.speechhelper.command.Command;
import com.speechhelper.model.Model;
import com.speechhelper.parsetext.ParseSpeechTextCommand;
import com.speechhelper.parsetext.WordCountUtility;
import com.speechhelper.speechtotext.GenerateReportCommand;
import com.speechhelper.speechtotext.ModifySpeechCommand;
import com.speechhelper.speechtotext.Speech;
import com.speechhelper.speechtotext.SpeechToTextCommand;

import org.springframework.stereotype.Controller;

@Controller
@ResponseBody
public class SpeakingHelperController {
	private Model model;
	
	public SpeakingHelperController() {
		
	}
	
	public SpeakingHelperController(Model m) {
		this.model = m;
	}
	
 	 @RequestMapping("/")
     @ResponseBody
     public String goToHomePage () {
         return "<h1>Backend Server is Running!</h1>";
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
		System.out.println(parseTextCommand.getFillerPercentage()+"% of content in speech is filler");
	}
}
