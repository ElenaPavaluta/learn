package books.thinkigInJava._4ThEdition.chapters.concurrency.simulation.distributingWork;

class WheelRobot extends Robot {
    public WheelRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    void performService() {
        System.out.println(this + " installing wheels");
        assembler.car().addWheels();
    }
}
