//@Author Christian Dummer
package com.speechhelper.speechtotext;

import java.io.File;

import com.speechhelper.constants.Constants;
import com.speechhelper.nullobjects.NullSpeechToTextReport;
import com.speechhelper.speechtotext.Speech.Builder;

//Class to store feedback on a particular speech recording.
public class SpeechToTextReport {
	protected String datapoints = "";
	protected String feedback = "";
	
	public SpeechToTextReport() {
		
	}
	

	protected SpeechToTextReport(Builder sb) {
		this.datapoints = sb.datapoints;
		this.feedback = sb.feedback;
	}
	
	public String getDatapoints() {
		return this.datapoints;
	}
	
	public String getFeedback() {
		return this.feedback;
	}
	
	public void setDatapoints(String s) {
		this.datapoints = s;
	}
	
	public void setFeedback(String s) {
		
	}
	
	//Implementation of builder pattern
	public static class Builder{
		protected String datapoints = "";
		protected String feedback = "";
		
		
		public SpeechToTextReport build() {
			return new SpeechToTextReport(this);
		}
		
		public Builder datapoints(String s) {
			this.datapoints = s;
			return this;
		}
		 
		public Builder feedback(String s) {
			this.feedback = s;
			return this;
		}
	
	}
}
