package gtk.designPatterns.creational.builder;

public class NewRobotBuilder implements RobotBuilder{

	private Robot robot;

	public NewRobotBuilder() {
		 robot =  new Robot();
	}
	
	@Override
	public void buildRobotHead() {
		robot.setRobotHead("New tin head");
	}

	@Override
	public void buildRobotTorso() {
		robot.setRobotTorso("New tin torso");
	}

	@Override
	public void buildRobotArms() {
		robot.setRobotArms("New blowtorch arms");
	}

	@Override
	public void buildRobotLegs() {
		robot.setRobotLegs("New roller skates");
	}

	@Override
	public Robot getRobot() {
		return robot;
	}
	
}
