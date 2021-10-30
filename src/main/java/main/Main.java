package main;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
