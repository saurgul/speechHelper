package testcases;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Test;

import com.speechhelper.main.Main;
import com.speechhelper.model.Model;
import com.speechhelper.speechtotext.SpeechToTextCommand;

public class SpeechToTextCommandTest {

	@Test
	public void test() {
		Model model = new Model();
		File audioFilePath;
		try {
			audioFilePath = new File(Main.class.getClassLoader().getResource("test.wav").toURI());
			SpeechToTextCommand command = new SpeechToTextCommand(model, audioFilePath);
			command.setSpeech(audioFilePath);
			command.execute();
			assert(command.getSpeech().toString().equals(audioFilePath.toString()));
			assert(command.getText().equals("  this is the first interval speaking  for the first moment of silence is the second of all speaking  so the for the moment of silence is a fuckin the role speaking and the last "));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		
	}

}
