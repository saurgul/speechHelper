package com.speechhelper.parsetext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FillerWordsUtility {

	public static FillerWordsUtility sharedInstance = getInstance();

	public HashMap<String, Integer> fillerFreq;
	public ArrayList<String> fillerWords;

	public FillerWordsUtility() {
		fillerWords = new ArrayList<String>();
		String path = getClass().getClassLoader().getResource("fillerWords.txt").getPath();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] fillers = line.split(",");
				for (String filler : fillers) {
					fillerWords.add(filler);
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println("File read issue");
		}
	}

	private static FillerWordsUtility getInstance() {
		if (sharedInstance == null) {
			sharedInstance = new FillerWordsUtility();
		}
		return sharedInstance;
	}

	public HashMap<String, Integer> getFillersFrequency(HashMap<String, Integer> wordFrequency) {

		fillerFreq = new HashMap<String, Integer>();
		for (String filler : fillerWords) {
			if (wordFrequency.containsKey(filler)) {
				fillerFreq.put(filler, wordFrequency.get(filler));
			}
		}
		return fillerFreq;
	}

	public Double getFillerWordsPercentage(Integer totalWords) {
		Integer totalFillerWords = 0;
		for (int i = 0; i < fillerFreq.values().size(); i++) {
			int n = (Integer) fillerFreq.values().toArray()[i];
			totalFillerWords += n;
		}
		return ((float) totalFillerWords / totalWords) * 100.0;
	}
}
