//@Author Christian Dummer
package com.speechhelper.speechtotext;


//Class to store feedback on a particular speech recording.
public class SpeechToTextReport {
	protected String wordFrequency = "";
	protected String fillerFrequency = "";
	protected String fillerRatio = "";
	protected double speechRate = 0;
	protected String feedback = "";
	
	public SpeechToTextReport() {
		
	}
	

	protected SpeechToTextReport(Builder sb) {
		this.wordFrequency = sb.wordFrequency;
		this.fillerFrequency = sb.fillerFrequency;
		this.fillerRatio = sb.fillerRatio;
		this.speechRate = sb.speechRate;
		this.feedback = sb.feedback;
	}
	
	
	//Implementation of builder pattern
	public static class Builder{
		protected String wordFrequency = "";
		protected String fillerFrequency = "";
		protected String fillerRatio = "";
		protected double speechRate = 0;
		protected String feedback = "";
		
		
		public SpeechToTextReport build() {
			return new SpeechToTextReport(this);
		}
		
		public Builder wordFrequency(String s) {
			this.wordFrequency = s;
			return this;
		}
		
		public Builder fillerFrequency(String s) {
			this.fillerFrequency = s;
			return this;
		}
		
		public Builder fillerRatio(String s) {
			this.fillerRatio = s;
			return this;
		}
		
		public Builder speechRate(double d) {
			this.speechRate = d;
			return this;
		}
		 
		public Builder feedback(String s) {
			this.feedback = s;
			return this;
		}
	
	}
}
