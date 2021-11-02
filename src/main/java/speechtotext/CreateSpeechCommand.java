package speechtotext;

import java.net.MalformedURLException;
import java.net.URL;
import command.Command;
import model.Model;
import nullobjects.NullSpeechToTextReport;
import utilities.FileDownloadUtility;

//Class to create a speech and store it in the model
public class CreateSpeechCommand implements Command {

	private Model model;
	private String urlString;
	
	public CreateSpeechCommand(Model model, String urlString) {
		this.model = model;
		this.urlString = urlString;
	}
	
	public void execute() {
		Speech newSpeech = new Speech("", new NullSpeechToTextReport(), new TranscribedSpeechText(getTextSpeechFrom(urlString)));
		model.addSpeech(newSpeech);
		System.out.print(newSpeech.getOriginalText());
	}

	public void unexecute() {
		// TODO Auto-generated method stub
		
	}
	
	private String getTextSpeechFrom(String urlString) {
		String speechText = "";
		try {
			speechText = FileDownloadUtility.getFileContents(new URL(urlString), "output.txt");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return speechText;
	}


}
