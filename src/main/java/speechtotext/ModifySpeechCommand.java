//@Author Christian Dummer
package speechtotext;

import command.Command;
import model.Model;

public class ModifySpeechCommand implements Command {
	private Model model;
	private Speech speech;
	public ModifySpeechCommand(Model m, Speech s) {
		this.model = m;
		this.speech = s;
	}
	public void execute() {
		// TODO Auto-generated method stub
		model.modifySpeech(this.speech);
	}

	public void unexecute() {
		// TODO Auto-generated method stub
		
	}

}
