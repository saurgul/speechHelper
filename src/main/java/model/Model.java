//@Author Christian Dummer
package model;

import java.util.ArrayList;

import command.Command;
import command.CommandInvoker;
import speechtotext.Speech;

//Basic model with an arraylist of speeches. See speechtotext.Speech for all that class contains.
public class Model {
	
	private ArrayList<Speech> speeches;
	private CommandInvoker commandInvoker;
	
	public Model() {
		speeches = new ArrayList<Speech>();
		this.commandInvoker = new CommandInvoker();
	}
	
	//TODO use a database for this 
	//Add, remove, and get list of speech transcriptions
	public ArrayList<Speech> getSpeeches(){
		return this.speeches;
	}
	
	public void addSpeech(Speech s) {
		speeches.add(s);
	}
	
	public void removeSpeech(Speech s) {
		speeches.remove(s);
	}
	
	
	//Use commandInvoker
	public void receiveCommand(Command c) {
		commandInvoker.receiveCommand(c);
	}

}
