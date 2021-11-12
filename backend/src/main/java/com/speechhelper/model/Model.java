//@Author Christian Dummer
package com.speechhelper.model;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.speechhelper.command.Command;
import com.speechhelper.command.CommandInvoker;
import com.speechhelper.main.Main;
import com.speechhelper.nullobjects.NullSpeech;
import com.speechhelper.nullobjects.NullSpeechToTextReport;
import com.speechhelper.speechtotext.Speech;
import com.speechhelper.speechtotext.SpeechToTextReport;

//Basic model with an arraylist of speeches. See speechtotext.Speech for all that class contains.
@Repository
public class Model {
	
	private ArrayList<Speech> speeches;
	private CommandInvoker commandInvoker;
	private int currentId = 0;
	
	public Model() {
		speeches = new ArrayList<Speech>();
		this.commandInvoker = new CommandInvoker();
	}
	
	//TODO use a database for this 
	//Add, remove, and get list of speech transcriptions
	public ArrayList<Speech> getSpeeches(){
		return this.speeches;
	}
	
	//TODO assign speech objects an ID when they are added. 
	public void addSpeech(Speech s) {
		s.setId(currentId);
		currentId++;
		speeches.add(s);
	}
	
	public Speech getSpeechById(int id) {
		for(Speech s: speeches) {
			if(s.getId() == id) {
				return s;
			}
		}
		return new NullSpeech();
	}
	
	public void removeSpeech(Speech s) {
		speeches.remove(s);
	}
	
	public void modifySpeech(Speech s) {
		//TODO implement Speech object ID and have this find object by id rather than by reference.
		speeches.set(speeches.indexOf(s), s);
	}
	
	public Speech getSpeech(Speech s) {
		//Returns a copy of a given speech
		return speeches.get(speeches.indexOf(s));
	}
	
	//Use commandInvoker
	public void receiveCommand(Command c) {
		commandInvoker.receiveCommand(c);
	}

}
