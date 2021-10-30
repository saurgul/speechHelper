//@Author Christian Dummer
package main;

import java.io.File;
import java.net.URISyntaxException;

import speechtotext.SpeechToText;
 
public class Main {

	//Default spring setup 
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		SpeechToText spt = new SpeechToText();
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
