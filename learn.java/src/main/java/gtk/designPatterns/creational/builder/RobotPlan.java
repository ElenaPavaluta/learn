package gtk.designPatterns.creational.builder;

public interface RobotPlan {

	void setRobotHead(String robotHead);

	void setRobotTorso(String robotTorso);

	void setRobotArms(String robotArms);

	void setRobotLegs(String robotLegs);
}
