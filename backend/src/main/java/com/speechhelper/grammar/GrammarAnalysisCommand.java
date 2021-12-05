//@Author Christian Dummer
package com.speechhelper.grammar;

import com.speechhelper.command.Command;
import com.speechhelper.constants.Constants;
import com.speechhelper.model.Model;
import com.speechhelper.speechtotext.Speech;
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
		 SpellChecker checker = new SpellChecker();

		 SpellResponse spellResponse = checker.check( "helloo worlrd" );

		 for( SpellCorrection sc : spellResponse.getCorrections() )
		    System.out.println( sc.getValue() );
	}

	public void unexecute() {
		// TODO
	}

}
