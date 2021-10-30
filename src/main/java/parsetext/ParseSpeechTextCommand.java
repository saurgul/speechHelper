package parsetext;

import java.util.HashMap;

import command.Command;
import model.Model;
import speechtotext.Speech;

public class ParseSpeechTextCommand implements Command {

	private Model model;
	private Speech speech;
	private HashMap<String, Integer> wordFrequency;
	private Integer totalWords;
	public ParseSpeechTextCommand(Model m, Speech s) {
		this.model = m;
		this.speech = s;
	}

	public void execute() {
		wordFrequency = WordCountUtility.sharedInstance.getWordFrequencyCount(model.getSpeech(speech).getText());
		setTotalWords(WordCountUtility.sharedInstance.getTotalWords());
	}

	public void unexecute() {
		// TODO Auto-generated method stub
	}
	
	public HashMap<String, Integer> getWordFreqeucnyCount() {
		return wordFrequency;
	}

	public Integer getTotalWords() {
		return totalWords;
	}
 
	public void setTotalWords(Integer totalWords) {
		this.totalWords = totalWords;
	} 
}
