//@Author Christian Dummer
package com.speechhelper.controller;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.speechhelper.command.Command;
import com.speechhelper.main.Main;
import com.speechhelper.model.Model;
import com.speechhelper.nullobjects.NullSpeech;
import com.speechhelper.parsetext.ParseSpeechTextCommand;
import com.speechhelper.speechtotext.CreateSpeechCommand;
import com.speechhelper.speechtotext.GenerateReportCommand;
import com.speechhelper.speechtotext.ModifySpeechCommand;
import com.speechhelper.speechtotext.Speech;
import com.speechhelper.speechtotext.SpeechToTextCommand;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


//This is our interface between the frontend and backend.
@RestController
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
		//System.out.println("Hello World!");
		return "<h1>Hello World!</h1>";
	}
	
	//This endpoint is currently configured to do the whole process of creating a speech and generating feedback
	@RequestMapping("/createSpeech")
	public Map<String, String> createSpeech(@RequestParam File textFile, @RequestParam File audioFile) {
		//Need to take file as an input for text file of speech instead of url
		//TODO actually use file from front end, rather than loading locally
		
		Speech testSpeech = new NullSpeech();
		try {
			//testSpeech = new Speech(audioFile, new String(Files.readAllBytes(textFile.toPath())));
			testSpeech = new Speech.Builder().speechFile(audioFile)
											 .input(new String(Files.readAllBytes(textFile.toPath())))
											 .build();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		SpeechToTextCommand speechToText = new SpeechToTextCommand(model, testSpeech);
		model.receiveCommand(speechToText);
		ParseSpeechTextCommand parseTextCommand = new ParseSpeechTextCommand(model, speechToText.getSpeechObject());
		model.receiveCommand(parseTextCommand);
		
		//REST Controller converts to json for us, so returning a key value pair will work for our response
		HashMap<String, String> values = new HashMap();
		values.put("WordFrequency", parseTextCommand.getWordFrequencyCount().toString());
		values.put("FillerFrequency", "{um = 3}");
		values.put("FillerRatio", "3:9");
		values.put("SpeechRate", parseTextCommand.getSpeechRate() + "");
		return values;
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
	public void speechToText(@RequestParam int speechId) {
		Command speechToTextCommand = new SpeechToTextCommand(model, model.getSpeechById(speechId).getSpeechFile());
		model.receiveCommand(speechToTextCommand);
	}
	
	@RequestMapping("/generateReport")
	//Generates feedback report on given speech object
	public void generateReport(@RequestParam int speechId) {
		Command generateReportCommand = new GenerateReportCommand(model, model.getSpeechById(speechId));
		model.receiveCommand(generateReportCommand);
	}
	
	@RequestMapping("/modifySpeech")
	//Modifies the stored speech object
	public void modifySpeech(@RequestParam int speechId) {
		Command modifySpeechCommand = new ModifySpeechCommand(model, model.getSpeechById(speechId));
		model.receiveCommand(modifySpeechCommand);
	}
	
	
	@RequestMapping("/parseText")
	//Performs content analyzer command
	public Map parseText(@RequestParam int speechId) {
		SpeechToTextCommand speechToText = new SpeechToTextCommand(model, model.getSpeechById(speechId));
		model.receiveCommand(speechToText);
		ParseSpeechTextCommand parseTextCommand = new ParseSpeechTextCommand(model, model.getSpeechById(speechId));
		model.receiveCommand(parseTextCommand);
		
		//Prints values to console
		System.out.println(parseTextCommand.getWordFrequencyCount().toString());
		System.out.println(parseTextCommand.getFillerFrequency().toString());
		System.out.printf(parseTextCommand.getFillerRatio());
		System.out.println(parseTextCommand.getSpeechRate());
		
		//REST Controller converts to json for us, so returning a key value pair will work for our response
		HashMap<String, String> values = new HashMap();
		values.put("WordFrequency", parseTextCommand.getWordFrequencyCount().toString());
		values.put("FillerFrequency", parseTextCommand.getFillerFrequency().toString());
		values.put("FillerRatio", parseTextCommand.getFillerRatio());
		values.put("SpeechRate", parseTextCommand.getSpeechRate() + "");
		return values;
	}
}
