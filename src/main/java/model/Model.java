//@Author Christian Dummer
package model;

import java.util.ArrayList;

import command.Command;
import command.CommandInvoker;

//Basic model with an arraylist of speeches. Will need to move type from string once we have longer speeches but string will do for now.
public class Model {
	
	private ArrayList<String> speeches;
	private CommandInvoker commandInvoker;
	
	public Model() {
		speeches = new ArrayList<String>();
		this.commandInvoker = new CommandInvoker();
	}
	
	//TODO use a database for this 
	//Add, remove, and get list of speech transcriptions
	public ArrayList<String> getSpeeches(){
		return this.speeches;
	}
	
	public void addSpeech(String s) {
		speeches.add(s);
	}
	
	public void removeSpeech(String s) {
		speeches.remove(s);
	}
	
	
	//Use commandInvoker
	public void receiveCommand(Command c) {
		commandInvoker.receiveCommand(c);
	}

}
