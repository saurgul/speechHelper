//@Author Christian Dummer
package com.speechhelper.grammar;

import com.speechhelper.command.Command;
import com.speechhelper.constants.Constants;
import com.speechhelper.model.Model;
import com.speechhelper.speechtotext.Speech;
import com.textrazor.AnalysisException;
import com.textrazor.NetworkException;
import com.textrazor.TextRazor;

public class GrammarAnalysisCommand implements Command {

	private Model model;
	private Speech speech;
	private TextRazor analyzer;
	
	public GrammarAnalysisCommand(Model m, Speech s) {
		this.model = m;
		this.speech = s;
		analyzer = new TextRazor(Constants.TEXT_RAZOR_API_KEY);
	}
	
	public void execute() { 
		try {
			analyzer.analyze(speech.getText());
			//System.out.println(analyzer.analyze(speech.getText()));
		} catch (NetworkException e) {
			e.printStackTrace();
		} catch (AnalysisException e) {
			e.printStackTrace();
		}
	}

	public void unexecute() {
		// TODO
	}

}
