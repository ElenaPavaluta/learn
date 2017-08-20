package designPatterns.behavioral.command;

public class VolumeDown implements Command {

	private ElectronicDevice ed;

	public VolumeDown(ElectronicDevice ed) {
		this.ed = ed;
	}

	@Override
	public void execute() {
		ed.volumeDown();
	}

	@Override
	public void undo() {
		ed.volumeUp();
	}

}
