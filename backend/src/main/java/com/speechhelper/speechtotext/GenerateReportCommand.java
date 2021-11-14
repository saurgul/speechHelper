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
	
	public GenerateReportCommand(Model m, Speech s) {
		this.model = m;
		this.speech = s;
	}
	
	public void execute() { 
		
	}

	public void unexecute() {
		// TODO
	}

}
