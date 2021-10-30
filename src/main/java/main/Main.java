//@Author Christian Dummer
package main;

import java.io.File;
import java.net.URISyntaxException;

import model.Model;
import speechtotext.SpeechToTextCommand;
 
public class Main {

	//Default spring setup 
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Model model = new Model();
		
		//Example speech to text command and execution.
		SpeechToTextCommand spt = new SpeechToTextCommand(model);
		try {
			spt.setSpeech(new File(Main.class.getClassLoader().getResource("test.wav").toURI()));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		spt.execute();
		System.out.println(spt.getText());
	}

}
