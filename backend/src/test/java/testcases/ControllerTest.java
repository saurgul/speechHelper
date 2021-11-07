package testcases;


import java.io.File;

import java.net.URISyntaxException;

import org.junit.Test;

import com.speechhelper.controller.SpeakingHelperController;
import com.speechhelper.main.Main;
import com.speechhelper.model.Model;
import com.speechhelper.speechtotext.Speech;
import com.speechhelper.speechtotext.SpeechToTextReport;



public class ControllerTest {
	@Test
	public void test() {
		
		try {
			Model model = new Model();
			
			File audioFilePath;
			audioFilePath = new File(Main.class.getClassLoader().getResource("test.wav").toURI());
			Speech speech = new Speech(audioFilePath, "Speechtotext", new SpeechToTextReport());
			model.addSpeech(speech);
			SpeakingHelperController cont = new SpeakingHelperController(model);
			cont.speechToText(audioFilePath);
			//cont.generateReport(speech);
			//cont.modifySpeech(speech);
			//cont.parseText(speech);
		   
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
