package com.speechhelper.utilities;

public class SpeechRateUtility {
	
	private Integer speechRate;
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
	
	public Integer getSpeechRate(Integer totalWords, double speechTime) {
		speechRate = (int) (totalWords/speechTime);
		return speechRate;
	}
	
}