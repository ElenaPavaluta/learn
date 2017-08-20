package designPatterns.creational.builder;

public class RobotEngineer {

	private RobotBuilder builder;

	public RobotEngineer(RobotBuilder builder) {
		this.builder = builder;
	}

	public void buildRobot() {
		builder.buildRobotHead();
		builder.buildRobotTorso();
		builder.buildRobotArms();
		builder.buildRobotLegs();
	}

	public Robot getRobot() {
		return builder.getRobot();
	}
}
