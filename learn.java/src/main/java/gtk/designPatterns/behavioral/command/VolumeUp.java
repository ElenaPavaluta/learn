package gtk.designPatterns.behavioral.command;

public class VolumeUp implements Command {

	private ElectronicDevice ed;

	public VolumeUp(ElectronicDevice ed) {
		this.ed = ed;
	}

	@Override
	public void execute() {
		ed.volumeUp();
	}

	@Override
	public void undo() {
		ed.volumeDown();
	}

}
