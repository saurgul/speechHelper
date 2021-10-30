//@Author Christian Dummer
package speechtotext;

import com.textrazor.AnalysisException;
import com.textrazor.NetworkException;
import com.textrazor.TextRazor;

import command.Command;
import constants.Constants;
import model.Model;

public class GenerateReportCommand implements Command {

	private Model model;
	private Speech speech;
	private TextRazor analyzer;
	
	public GenerateReportCommand(Model m, Speech s) {
		this.model = m;
		this.speech = s;
		analyzer = new TextRazor(Constants.TEXT_RAZOR_API_KEY);
	}
	
	public void execute() {
		// TODO 
		try {
			System.out.println(analyzer.analyze(speech.getText()));
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
