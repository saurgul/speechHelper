//@Author Christian Dummer
package com.speechhelper.grammar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.speechhelper.command.Command;
import com.speechhelper.constants.Constants;
import com.speechhelper.main.Main;
import com.speechhelper.model.Model;
import com.speechhelper.speechtotext.Speech;
import com.speechhelper.utilities.GrammarUtility;
import com.swabunga.spell.engine.SpellDictionaryHashMap;
import com.swabunga.spell.event.SpellCheckListener;
import com.swabunga.spell.event.SpellChecker;
import com.swabunga.spell.event.StringWordTokenizer;
import com.swabunga.spell.event.WordTokenizer;
import com.textrazor.TextRazor;

public class GrammarAnalysisCommand implements Command {

	private Model model;
	private Speech speech;
	private SpellChecker checker;
	
	public GrammarAnalysisCommand(Model m, Speech s) {
		this.model = m;
		this.speech = s;
		checker = new SpellChecker();
	}
	
	public void execute() {
		HashMap<String, String> grammarSuggestions = GrammarUtility.sharedInstance.evaluate(speech.getInput());
		speech.getReport()
	}

	
	
	public void unexecute() {
		// TODO
	}

}
