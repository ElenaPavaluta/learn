package gtk.designPatterns.creational.builder;

class Run {

	public static void main(String[] args) {
		RobotEngineer engineer;
		
		OldRobotBuilder oldRobotBuilder = new OldRobotBuilder();
		
		engineer = new RobotEngineer(oldRobotBuilder);
		engineer.buildRobot();
		System.out.println(engineer.getRobot().getRobotHead());
		
		engineer = new RobotEngineer(new NewRobotBuilder());
		engineer.buildRobot();
		System.out.println(engineer.getRobot().getRobotHead());
	}
}
