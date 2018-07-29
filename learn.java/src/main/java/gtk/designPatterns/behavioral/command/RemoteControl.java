package gtk.designPatterns.behavioral.command;

public class RemoteControl {

    private DeviceButton btnOn;
    private DeviceButton btnOff;
    private DeviceButton btnVolumeUp;
    private DeviceButton btnVolumeDown;

    public RemoteControl(ElectronicDevice ed) {
        btnOn = new DeviceButton(new TurnOn(ed));
        btnOff = new DeviceButton(new TurnOff(ed));
        btnVolumeUp = new DeviceButton(new VolumeUp(ed));
        btnVolumeDown = new DeviceButton(new VolumeDown(ed));
    }

    public void btnOn() {
        btnOn.press();
    }

    public void undoBtnOn() {
        btnOn.pressUndo();
    }

    public void btnOff() {
        btnOff.press();
    }

    public void btnVolumeUp() {
        btnVolumeUp.press();
    }

    public void btnVolumeDown() {
        btnVolumeDown.press();
    }

}
