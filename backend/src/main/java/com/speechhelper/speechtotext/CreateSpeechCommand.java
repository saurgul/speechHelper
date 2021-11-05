package com.speechhelper.speechtotext;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import com.speechhelper.command.Command;
import com.speechhelper.model.Model;
import com.speechhelper.nullobjects.NullSpeechToTextReport;
import com.speechhelper.utilities.FileDownloadUtility;

//Class to create a speech and store it in the model
public class CreateSpeechCommand implements Command {

	private Model model;
	private String urlString;
	private File speechFile;
	
	public CreateSpeechCommand(Model model, String urlString, File speechFile) {
		this.model = model;
		this.urlString = urlString;
		this.speechFile = speechFile;
	}
	
	public void execute() {
		Speech newSpeech = new Speech(speechFile, new NullSpeechToTextReport(), new TranscribedSpeechText(getTextSpeechFrom(urlString)));
		model.addSpeech(newSpeech);
		System.out.print(newSpeech.getOriginalText());
	}

	public void unexecute() {
		// TODO Auto-generated method stub
		
	}
	
	private String getTextSpeechFrom(String urlString) {
		String speechText = "";
		try {
			speechText = FileDownloadUtility.getFileContents(new URL(urlString), "output.txt");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return speechText;
	}


}
