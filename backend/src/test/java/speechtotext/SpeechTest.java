package speechtotext;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Test;

import com.speechhelper.main.Main;
import com.speechhelper.speechtotext.Speech;
import com.speechhelper.speechtotext.SpeechToTextReport;

public class SpeechTest {

	@Test
	public void test() {
		File audioFilePath;
		try {
			audioFilePath = new File(Main.class.getClassLoader().getResource("test.wav").toURI());
			Speech speech = new Speech(audioFilePath, "Speech to text", new SpeechToTextReport());
			
			assert(speech.getText().equals("Speech to text"));
			assert(speech.getSpeechFile().getPath().toString().equals(audioFilePath.getPath().toString()));
			assertFalse(speech.copy().toString().equals(speech.toString()));
	
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
