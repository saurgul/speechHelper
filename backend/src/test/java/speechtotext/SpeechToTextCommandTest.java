package speechtotext;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Test;

import com.speechhelper.main.Main;
import com.speechhelper.model.Model;
import com.speechhelper.parsetext.ParseSpeechTextCommand;
import com.speechhelper.speechtotext.GenerateReportCommand;
import com.speechhelper.speechtotext.SpeechToTextCommand;

public class SpeechToTextCommandTest {

	/*@Test
	public void test() {
		Model model = new Model();
		File audioFilePath;
		try {
			audioFilePath = new File(Main.class.getClassLoader().getResource("test.wav").toURI());
			SpeechToTextCommand command = new SpeechToTextCommand(model, audioFilePath);
			command.setSpeech(audioFilePath);
			command.execute();
			assert(command.getSpeech().toString().equals(audioFilePath.toString()));
			assert(command.getText().equals(" this is the first interval speaking  for the first moment of silence is the second of all speaking  so the for the moment of silence is a fucking several speaking and the last "));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		
	}*/
	
	@Test
	public void customDictTest() {
		Model model = new Model();
		File audioFilePath;
		try {
			audioFilePath = new File(Main.class.getClassLoader().getResource("test.wav").toURI());
			String input = "This is the first interval of speaking. After the first moment of silence this is the second interval of speaking. After the third moment of silence this the third interval of speaking and the last one";
			SpeechToTextCommand command = new SpeechToTextCommand(model, audioFilePath, input);
			command.execute();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void fillerWordTest() {
		Model model = new Model();
		File audioFilePath;
		try {
			audioFilePath = new File(Main.class.getClassLoader().getResource("fillerDemo.wav").toURI());
			String input = "This is a demo for the speaking helper and this demo has a lot of filler words";
			SpeechToTextCommand command = new SpeechToTextCommand(model, audioFilePath, input);
			command.execute();
			
			ParseSpeechTextCommand secondCommand = new ParseSpeechTextCommand(model, model.getSpeeches().get(model.getSpeeches().size() - 1));
			secondCommand.execute();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
