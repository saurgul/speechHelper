//@Author Christian Dummer
package com.speechhelper.speechtotext;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.speechhelper.constants.Constants;
import com.speechhelper.nullobjects.NullSpeechToTextReport;


//This is a container class for speech objects, the text transcription, and the feedback.
//This will be the main thing we store in our database.
public class Speech {
	protected File speechFile;
	protected SpeechToTextReport report;
	protected String speechToText;
	protected String input;
	protected int speechId;
	protected TranscribedSpeechText transcribedSpeechText;
	
	private Speech(Builder sb) {
		this.speechFile = sb.speechFile;
		this.report = sb.report;
		this.speechToText = sb.speechToText;
		this.input = sb.input;
		this.speechId = sb.speechId;
	}
	
	/*public Speech(File speechFile, String speechToText, SpeechToTextReport report) {
		this.speechFile = speechFile;
		this.speechToText = speechToText;
		this.report = report;
	}
	
	public Speech(File speechFile, SpeechToTextReport report) {
		this.speechFile = speechFile;
		this.report = report;
	}
	
	public Speech(File speechFile, TranscribedSpeechText transcribedSpeechText) {
		this.speechFile = speechFile;
		this.transcribedSpeechText = transcribedSpeechText;
	}
	
	//the transcribedSpeechText object contains the originalText downloaded from the url and parsed text that can be used to compare the original and parsed text
	public Speech(SpeechToTextReport report, TranscribedSpeechText transcribedSpeechText) {
		this.report = report;
		this.transcribedSpeechText = transcribedSpeechText;
	}
	
	public Speech(File speechFile, String input) {
		this.speechFile = speechFile;
		this.input = input;
	} */
	
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
	
	public String getInput() {
		return this.input;
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
	
	public void setSpeechToText(String s) {
		this.speechToText = s;
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
		return durationInSeconds/60;
	}
	
	
	//Implementation of builder pattern
	public static class Builder{
		protected File speechFile = new File("");
		protected SpeechToTextReport report = new NullSpeechToTextReport();
		protected String speechToText = "";
		protected String input = "";
		protected int speechId = Constants.NULL_SPEECH_ID;
		
		
		public Speech build() {
			return new Speech(this);
		}
		
		public Builder speechFile(File s) {
			this.speechFile = s;
			return this;
		}
		 
		public Builder report(SpeechToTextReport r) {
			this.report = r;
			return this;
		}
		
		public Builder speechToText(String s) {
			this.speechToText = s;
			return this;
		}
		
		public Builder input(String s) {
			this.input = s;
			return this;
		}
		
		public Builder id(int i) {
			this.speechId = i;
			return this;
		}
	}
	
}
