package designPatterns.behavioral.command;

public class TurnOn implements Command {

	private ElectronicDevice ed;

	public TurnOn(ElectronicDevice tv) {
		this.ed = tv;
	}

	@Override
	public void execute() {
		ed.on();
	}

	@Override
	public void undo() {
		ed.off();
	}

}
