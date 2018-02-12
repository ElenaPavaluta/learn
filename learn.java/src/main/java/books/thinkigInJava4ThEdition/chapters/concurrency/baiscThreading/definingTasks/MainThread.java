package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.definingTasks;

class MainThread {

    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
