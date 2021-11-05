//@Author Christian Dummer
package com.speechhelper.speechtotext;

import java.io.File;

//This is a container class for speech objects, the text transcription, and the feedback.
//This will be the main thing we store in our database.
//TODO update datatype for the actual speechToText variable, add more fields
public class Speech {
	private File speechFile;
	private SpeechToTextReport report;
	private String speechToText;
	private int speechId;
	private TranscribedSpeechText transcribedSpeechText;
	
	public Speech() {
	}
	
	public Speech(File speechFile, String speechToText, SpeechToTextReport report) {
		this.speechFile = speechFile;
		this.speechToText = speechToText;
		this.report = report;
	}
	
	//the transcribedSpeechText object contains the originalText downloaded from the url and parsed text that can be used to compare the original and parsed text
	public Speech(File speechFile, SpeechToTextReport report, TranscribedSpeechText transcribedSpeechText) {
		this.speechFile = speechFile;
		this.report = report;
		this.transcribedSpeechText = transcribedSpeechText;
	}
	
	public String getText() {
		return this.speechToText;
	}
	
	public File getSpeechFile() {
		return this.speechFile;
	}
	
	public SpeechToTextReport getReport() {
		return this.report;
	}
	
	public int getId() {
		return this.speechId;
	}
	
	public String getOriginalText() {
		return transcribedSpeechText.getOriginalText();
	}
	
	public String getParsedText() {
		return transcribedSpeechText.getParsedText();
	}
	
	public void setParsedText(String cleanText) {
		transcribedSpeechText.setParsedText(cleanText);
	}
	
	//Returns a copy
	public Speech copy() {
		return new Speech(speechFile, speechToText, report);
	}
	
}
