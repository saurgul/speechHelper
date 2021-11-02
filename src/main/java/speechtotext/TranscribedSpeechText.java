package speechtotext;

//Class to represent an Speech object's property containing the original text and the  clean parsed text
public class TranscribedSpeechText {
	private String originalText;
	private String parsedText;
	
	public TranscribedSpeechText(String originalText) {
		this.originalText = originalText;
	}
	
	public String getOriginalText() {
		return originalText;
	}
	public void setOriginalText(String originalText) {
		this.originalText = originalText;
	} 
	
	public String getParsedText() {
		return parsedText;
	}
	
	public void setParsedText(String parsedText) {
		this.parsedText = parsedText;
	}

}

