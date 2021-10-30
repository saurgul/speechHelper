//@Author Christian Dummer
package speechtotext;

import java.io.File;

//This is a container class for speech objects, the text transcription, and the feedback.
//This will be the main thing we store in our database.
//TODO update datatype for the actual speechToText variable, add more fields
public class Speech {
	private File speechFile;
	private SpeechToTextReport report;
	private String speechToText;
	private int speechId;
	
	
	public Speech() {
		
	}
	
	public Speech(File speechFile, String speechToText, SpeechToTextReport report) {
		this.speechFile = speechFile;
		this.speechToText = speechToText;
		this.report = report;
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
	
}
