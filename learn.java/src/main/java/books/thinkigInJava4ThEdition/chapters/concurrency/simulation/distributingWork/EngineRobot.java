package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.distributingWork;

class EngineRobot extends Robot {
    public EngineRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    void performService() {
        System.out.println(this + " installingEngine");
        assembler.car().addEngine();
    }
}
