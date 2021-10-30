//@Author Christian Dummer
package speechtotext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import command.Command;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import model.Model;
import nullobjects.NullSpeechToTextReport;

//TODO builder pattern for 
public class SpeechToTextCommand implements Command{  
	private Model model;
	private Configuration config;
	private File speech;
	private String text = "";
	private Speech speechContainer;
	
	public SpeechToTextCommand(Model m) {
		this.model = m;
        setConfig();
	}
	
	public SpeechToTextCommand(Model m, File speech) {
		this.speech = speech;
		this.model = m;
		setConfig();
	}
	
	public void setConfig() {
		//Default configuration for speech to text, using Sphinx models and dictionaries.
		config = new Configuration();
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        config.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
	}
	
	//Getters and Setters
	public File getSpeech() {
		return this.speech;
	}
	
	public void setSpeech(File newSpeech) {
		this.speech = newSpeech;
	}
	
	public String getText() {
		return this.text;
	}
	
	//Command interface methods
	public void execute() {
		/* TODO, implement below code in live speech recognizer
		LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
		// Start recognition process pruning previously cached data.
		recognizer.startRecognition(true);
		SpeechResult result = recognizer.getResult();
		// Pause recognition process. It can be resumed then with startRecognition(false).
		recognizer.stopRecognition();
		*/
		
		
		
		//Code for speech to text from audio file
		try {
			StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(config);
			InputStream stream = new FileInputStream(speech);
			
			//Runs recognition and sets the best result as the given text output
			recognizer.startRecognition(stream);
	        SpeechResult result;
	        while ((result = recognizer.getResult()) != null) {
	            for (String s : result.getNbest(1)) {
	            	//System.out.println(s);
	                text += s;
	            }
	        }
	        //Removes String tags from output
	        text = text.replaceAll("<s>", "");
	        text = text.replaceAll("</s>", "");
	        
	        //Creates a container object
	        speechContainer = new Speech(speech, text, new NullSpeechToTextReport());
	        
	        //Adds it to model
	        model.addSpeech(speechContainer);
	        
	        //Println for debugging
	        System.out.println(text);
	        
	        recognizer.stopRecognition();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void unexecute() {
		model.removeSpeech(speechContainer);
	}

}