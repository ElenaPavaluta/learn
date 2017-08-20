package designPatterns.creational.builder;

public class OldRobotBuilder implements RobotBuilder {

	private Robot robot;

	public OldRobotBuilder() {
		robot = new Robot();
	}

	@Override
	public void buildRobotHead() {
		robot.setRobotHead("Old tin head");
	}

	@Override
	public void buildRobotTorso() {
		robot.setRobotTorso("Old tin torso");
	}

	@Override
	public void buildRobotArms() {
		robot.setRobotArms("Old blowtorch arms");
	}

	@Override
	public void buildRobotLegs() {
		robot.setRobotLegs("Old roller skates");
	}

	@Override
	public Robot getRobot() {
		return robot;
	}

}
