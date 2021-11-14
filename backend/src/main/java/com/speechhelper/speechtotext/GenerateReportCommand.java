//@Author Christian Dummer
package com.speechhelper.speechtotext;

import java.util.ArrayList;

import com.speechhelper.command.Command;
import com.speechhelper.constants.Constants;
import com.speechhelper.model.Model;
import com.textrazor.AnalysisException;
import com.textrazor.NetworkException;
import com.textrazor.TextRazor;

public class GenerateReportCommand implements Command {

	private Model model;
	private Speech speech;
	private SpeechToTextReport report;
	
	public GenerateReportCommand(Model m, Speech s) {
		this.model = m;
		this.speech = s;
	}
	
	public void execute() { 
		report = speech.getReport();
		wordFrequencyFeedback();
		fillerFrequencyFeedback();
		fillerRatioFeedback();
		speechRateFeedback();
	}
	
	private void wordFrequencyFeedback() {
		//TODO frequency feedback
	}
	
	private void fillerFrequencyFeedback() {
		//TODO fillerFrequencyFeedback
	}
	
	private void fillerRatioFeedback() {
		//TODO fillerRatioFeedback
	}
	
	private void speechRateFeedback() {
		double rate = report.getSpeechRate();
		String feedback = "";
		if(rate < 140) {
			feedback = "Your speaking is a little on the slower end. Try picking up the pace! An average speaking rate is ~140 - 160 words per minute.";
		}
		else if(rate > 160) {
			
		}
		
		report.setFeedback(report.getFeedback() + feedback);
	}

	public void unexecute() {
		// TODO
	}

}
