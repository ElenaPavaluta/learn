package gtk.designPatterns.behavioral.command;

import gtk.designPatterns.behavioral.command.Command;

public class TurnOff implements Command {

	private ElectronicDevice ed;

	public TurnOff(ElectronicDevice ed) {
		this.ed = ed;
	}

	@Override
	public void execute() {
		ed.off();
	}

	@Override
	public void undo() {
		ed.on();
	}
	
	
}
