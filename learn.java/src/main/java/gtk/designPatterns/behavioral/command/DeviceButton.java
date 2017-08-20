package designPatterns.behavioral.command;

/**
 * This is known as the invoker It has a method press() that when executed
 * causes the execute method to be called The execute method for the Command
 * interface then calls the method assigned in the class that implements the
 * Command interface
 * 
 * 
 */
public class DeviceButton {

	private Command command;

	public DeviceButton(Command command) {
		this.command = command;
	}

	public void press(){
		command.execute();
	}
	
	public void pressUndo(){
		command.undo();
	}
}
