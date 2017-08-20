package designPatterns.behavioral.command;

public class Run {

	public static void main(String[] args) {
		ElectronicDevice tv = Devices.getTv();
//		ElectronicDevice radio = Devices.getRadio();
		
		RemoteControl rc = new RemoteControl(tv);
		
		rc.btnOn();
		rc.btnVolumeUp();
		rc.btnVolumeUp();
		rc.btnVolumeUp();
		rc.btnVolumeUp();
		rc.btnVolumeDown();
		rc.btnOff();
	}
}
