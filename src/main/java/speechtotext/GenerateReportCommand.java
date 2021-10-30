//@Author Christian Dummer
package speechtotext;

import command.Command;
import model.Model;

public class GenerateReportCommand implements Command {

	private Model model;
	private Speech speech;
	
	public GenerateReportCommand(Model m, Speech s) {
		this.model = m;
		this.speech = s;
	}
	
	public void execute() {
		// TODO 
		
		model.receiveCommand(this);
	}

	public void unexecute() {
		// TODO
	}

}
