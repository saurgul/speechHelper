//@Author Christian Dummer
package command;

public interface Command {
	
	public void execute();
	
	public void unexecute();
}
