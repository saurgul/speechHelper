package testcases;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Test;

import com.speechhelper.main.Main;
import com.speechhelper.model.Model;
import com.speechhelper.speechtotext.Speech;
import com.speechhelper.speechtotext.SpeechToTextReport;


public class ModelTest {
	@Test
	public void test() {
		File audioFilePath;
		try {
			audioFilePath = new File(Main.class.getClassLoader().getResource("test.wav").toURI());
			Speech speech = new Speech(audioFilePath, "Speech to text", new SpeechToTextReport());
			Model model = new Model();
			model.addSpeech(speech);
			model.removeSpeech(speech);
			model.addSpeech(speech);
			model.modifySpeech(speech);
			model.getSpeech(speech);
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
