package com.speechhelper.utilities;

public class SpeechRateUtility {
	
	private double speechRate;
	public static SpeechRateUtility sharedInstance = getInstance();
	
	public SpeechRateUtility(){
		speechRate = 0;
	}
	
	private static SpeechRateUtility getInstance() {
		if (sharedInstance == null) {
			sharedInstance = new SpeechRateUtility();
		}
		return sharedInstance;
	}
	
	public double getSpeechRate(Integer totalWords, double speechTime) {
		speechRate = (totalWords/speechTime);
		return speechRate;
	}
	
}