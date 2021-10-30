package parsetext;

import java.util.HashMap;

public class WordCountUtility {

	public static WordCountUtility sharedInstance = getInstance();

	private HashMap<String, Integer> wordFreqTable;
	private Integer totalWords;

	private WordCountUtility() {
		wordFreqTable = new HashMap<String, Integer>();
		totalWords = 0;
	}

	private static WordCountUtility getInstance() {
		if (sharedInstance == null) {
			sharedInstance = new WordCountUtility();
		}
		return sharedInstance;
	}

	public HashMap<String, Integer> countWordFrequencyFor(String parsedText) {
		String[] words = parsedText.split(" ");
		for (String word : words) {
			totalWords += 1;
			if (wordFreqTable.containsKey(word)) {
				wordFreqTable.put(word,  wordFreqTable.get(word) + 1);
			} else {
				wordFreqTable.put(word, 1);
			}
		}
		return wordFreqTable;
	}
	
	public HashMap<String, Integer> getWordFrequencyCount(String parsedText) {
		return countWordFrequencyFor(parsedText);
	}
	
	public void clearWordCount() {
		wordFreqTable.clear();
		totalWords = 0;
	}
	
	public Integer getTotalWords() {
		return totalWords;
	}
	
}
