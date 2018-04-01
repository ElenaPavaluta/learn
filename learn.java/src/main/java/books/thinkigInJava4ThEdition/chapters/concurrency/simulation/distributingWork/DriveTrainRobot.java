package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.distributingWork;

class DriveTrainRobot extends Robot {

    public DriveTrainRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    void performService() {
        System.out.println(this + " installing driveTrain");
        assembler.car().addDriveTrain();
    }
}
