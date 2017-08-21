package gtk.designPatterns.behavioral.command;

public class Devices {

	static Television getTv() {
		return new Television ();
	}

	static Radio getRadio() {
		return new Radio ();
	}
}
