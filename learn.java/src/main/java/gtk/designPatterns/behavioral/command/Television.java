package designPatterns.behavioral.command;

public class Television implements ElectronicDevice {

	private int volume = 0;

	@Override
	public void on() {
		System.out.println("Tv is on");
	}

	@Override
	public void off() {
		System.out.println("Tv is off");
	}

	@Override
	public void volumeUp() {
		volume++;
		System.out.println("Tv volume is at: " + volume);
	}

	@Override
	public void volumeDown() {
		volume--;
		System.out.println("Tv volume is at: " + volume);
	}

}
