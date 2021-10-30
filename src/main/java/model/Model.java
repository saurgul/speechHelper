//@Author Christian Dummer
package model;

import java.util.ArrayList;

//Basic model with an arraylist of speeches. Will need to move type from string once we have longer speeches but string will do for now.
public class Model {
	
	private ArrayList<String> speeches;
	
	public Model() {
		speeches = new ArrayList<String>();
	}
	
	public ArrayList<String> getSpeeches(){
		return this.speeches;
	}
	
	public void addSpeech(String s) {
		speeches.add(s);
	}
	
	public void removeSpeech(String s) {
		speeches.remove(s);
	}

}
