package com.speechhelper.parsetext;

import java.util.HashMap;

import com.speechhelper.command.Command;
import com.speechhelper.model.Model;
import com.speechhelper.speechtotext.Speech;

//Class to parse the original text and count the number of words and filler words
//TODO: remove the filler words from the original text and set parsed text fort the speech
public class ParseSpeechTextCommand implements Command {

	private Model model;
	private Speech speech;
	private HashMap<String, Integer> wordFrequency;
	private HashMap<String, Integer> fillerFrequency;
	private Integer totalWords;
	private Double fillerPercentage;
	public ParseSpeechTextCommand(Model m, Speech s) {
		this.model = m;
		this.speech = s;
	}

	public void execute() {
		String speechText = speech.getText();
		wordFrequency = WordCountUtility.sharedInstance.getWordFrequencyCount(speechText);
		setTotalWords(WordCountUtility.sharedInstance.getTotalWords());
		fillerFrequency = FillerWordsUtility.sharedInstance.getFillersFrequency(wordFrequency);
		fillerPercentage = FillerWordsUtility.sharedInstance.getFillerWordsPercentage(totalWords);
//		speech.setParsedText(generateCleanText());
	}

	public void unexecute() {
		// TODO Auto-generated method stub
	}
	
	public HashMap<String, Integer> getWordFrequencyCount() {
		return wordFrequency;
	}
	
	public HashMap<String, Integer> getFillerFrequency() {
		return fillerFrequency;
	}

	public Integer getTotalWords() {
		return totalWords;
	}
 
	public void setTotalWords(Integer totalWords) {
		this.totalWords = totalWords;
	} 
	
	public Double getFillerPercentage() {
		return fillerPercentage;
	}
	
	private String generateCleanText() {
		return "";
	}
}
