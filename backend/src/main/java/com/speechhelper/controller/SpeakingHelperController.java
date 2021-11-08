//@Author Christian Dummer
package com.speechhelper.controller;

import java.io.File;
import java.net.URI;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.speechhelper.command.Command;
import com.speechhelper.model.Model;
import com.speechhelper.nullobjects.NullSpeech;
import com.speechhelper.parsetext.ParseSpeechTextCommand;
import com.speechhelper.speechtotext.CreateSpeechCommand;
import com.speechhelper.speechtotext.GenerateReportCommand;
import com.speechhelper.speechtotext.ModifySpeechCommand;
import com.speechhelper.speechtotext.Speech;
import com.speechhelper.speechtotext.SpeechToTextCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


//This is our interface between the frontend and backend.
@Controller
@ResponseBody
public class SpeakingHelperController {
	@Autowired
	private Model model;
	
	public SpeakingHelperController() {
		
	}
	
	public SpeakingHelperController(Model m) {
		this.model = m;
	}
	

	//Example mapping for a request from the frontend
	@RequestMapping("/test")
	public String getTest() {
		System.out.println("Hello World!");
		return "<h1>Hello World!</h1>";
	}
	
	@RequestMapping("/createSpeech")
	public void createSpeech(@RequestParam String urlString, @RequestParam File file) {
		//Need to take file as an input for text file of speech instead of url
		Command createSpeechCommand = new CreateSpeechCommand(model, urlString, file);
		model.receiveCommand(createSpeechCommand);
		//call parseSpeechTextCommand to get fillerwords ratio and speechrate
	}
	
	//Create a speech from the downloaded file Content
	public void createSpeech(@RequestParam String urlString) {
		Command createSpeechCommand = new CreateSpeechCommand(model, urlString);
		model.receiveCommand(createSpeechCommand);
	}
	
	//Create a speech from the audio file Content
	public void createSpeech(@RequestParam File file) {
		Command createSpeechCommand = new CreateSpeechCommand(model, file);
		model.receiveCommand(createSpeechCommand);
	}

	//Performs speech to text command
	@RequestMapping("/speechToText")
	public void speechToText(@RequestParam URI filepath) {
		Command speechToTextCommand = new SpeechToTextCommand(model, filepath);
		model.receiveCommand(speechToTextCommand);
	}
	
	//Generates feedback report on given speech object
	public void generateReport(@RequestParam int speechId) {
		//TODO, change second parameter to model.findSpeechById (Currently does not exist)
		Command generateReportCommand = new GenerateReportCommand(model, new NullSpeech());
		model.receiveCommand(generateReportCommand);
	}
	
	//Modifies the stored speech object
	public void modifySpeech(@RequestParam int speechId) {
		//TODO, change second parameter to model.findSpeechById (Currently does not exist)
		Command modifySpeechCommand = new ModifySpeechCommand(model, new NullSpeech());
		model.receiveCommand(modifySpeechCommand);
	}
	
	//Performs content analyzer command
	public void parseText(@RequestParam int speechId) {
		//TODO, change second parameter to model.findSpeechById (Currently does not exist)
		ParseSpeechTextCommand parseTextCommand = new ParseSpeechTextCommand(model, new NullSpeech());
		model.receiveCommand(parseTextCommand);
		System.out.println(parseTextCommand.getWordFrequencyCount().toString());
		System.out.println(parseTextCommand.getFillerFrequency().toString());
		System.out.printf(parseTextCommand.getFillerRatio());
		System.out.println(parseTextCommand.getSpeechRate());
	}
}
