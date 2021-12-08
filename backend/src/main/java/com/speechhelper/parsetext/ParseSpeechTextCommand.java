package com.speechhelper.parsetext;

import java.util.ArrayList;
import java.util.HashMap;

import com.speechhelper.command.Command;
import com.speechhelper.model.Model;
import com.speechhelper.speechtotext.Speech;
import com.speechhelper.speechtotext.SpeechToTextReport;
import com.speechhelper.utilities.FillerWordsUtility;
import com.speechhelper.utilities.GrammarUtility;
import com.speechhelper.utilities.SpeechRateUtility;
import com.speechhelper.utilities.WordCountUtility;

//Class to parse the original text and count the number of words and filler words
//TODO: remove the filler words from the original text and set parsed text fort the speech
public class ParseSpeechTextCommand implements Command {

	private Model model;
	private Speech speech;
	private HashMap<String, Integer> wordFrequency;
	private HashMap<String, Integer> fillerFrequency;
	private Integer totalWords;
	private String fillerRatio;
	private double speechRate;
	private HashMap<String, String> spellingFixes;
	public ParseSpeechTextCommand(Model m, Speech s) {
		this.model = m;
		this.speech = s;
	}


	public void execute() {
		String speechText = speech.getText();
		wordFrequency = WordCountUtility.sharedInstance.getWordFrequencyCount(speechText);
		setTotalWords(WordCountUtility.sharedInstance.getTotalWords());
		fillerFrequency = FillerWordsUtility.sharedInstance.getFillersFrequency(wordFrequency);
		fillerRatio = FillerWordsUtility.sharedInstance.getFillerWordsRatio(totalWords);
		speechRate = SpeechRateUtility.sharedInstance.getSpeechRate(totalWords,speech.getSpeechlength());
		spellingFixes = GrammarUtility.sharedInstance.evaluate(speech.getInput());
		
		speech.setSpeechToTextReport(new SpeechToTextReport.Builder().wordFrequency(wordFrequency.toString())
																	 .fillerFrequency(fillerFrequency.toString())
																	 .fillerRatio(fillerRatio)
																	 .speechRate(speechRate)
																	 .spellingFixes(spellingFixes)
																	 .build());
		System.out.println("Word Frequency: " + wordFrequency);
		System.out.println("FillerFrequency: " + fillerFrequency);
		System.out.println("Filler Ratio: " + fillerRatio);
		System.out.println("Speech Rate: " + speechRate);
		System.out.println("Spelling Fixes: " + spellingFixes);
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
	

	public HashMap<String, String> getSpellingFixes() {
		return spellingFixes;
	}

	public void setGrammarSuggestions(HashMap<String, String> spellingFixes) {
		this.spellingFixes = spellingFixes;
	}

	public Integer getTotalWords() {
		return totalWords;
	}
 
	public void setTotalWords(Integer totalWords) {
		this.totalWords = totalWords;
	} 
	
	public String getFillerRatio() {
		return fillerRatio;
	}
	
	public double getSpeechRate() {
		return speechRate;
	}
	
	private String generateCleanText() {
		return "";
	}
}
