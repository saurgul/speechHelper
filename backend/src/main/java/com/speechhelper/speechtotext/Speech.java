//@Author Christian Dummer
package com.speechhelper.speechtotext;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;


//This is a container class for speech objects, the text transcription, and the feedback.
//This will be the main thing we store in our database.
//TODO update datatype for the actual speechToText variable, add more fields
public class Speech {
	protected File speechFile;
	protected SpeechToTextReport report;
	protected String speechToText;
	protected int speechId;
	protected TranscribedSpeechText transcribedSpeechText;
	
	public Speech() {
	}
	
	public Speech(File speechFile, String speechToText, SpeechToTextReport report) {
		this.speechFile = speechFile;
		this.speechToText = speechToText;
		this.report = report;
	}
	
	public Speech(File speechFile, SpeechToTextReport report) {
		this.speechFile = speechFile;
		this.report = report;
	}
	
	//the transcribedSpeechText object contains the originalText downloaded from the url and parsed text that can be used to compare the original and parsed text
	public Speech(SpeechToTextReport report, TranscribedSpeechText transcribedSpeechText) {
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
	
	public void setId(int id) {
		this.speechId = id;
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
	
	public double getSpeechlength() {
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(speechFile);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AudioFormat format = audioInputStream.getFormat();
		long frames = audioInputStream.getFrameLength();
		double durationInSeconds = (frames+0.0) / format.getFrameRate(); 
		return durationInSeconds;
	}
	
	//Returns a copy
	public Speech copy() {
		return new Speech(speechFile, speechToText, report);
	}
	
}
