package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.distributingWork;

class Car {

    private final int id;
    protected boolean engine = false,
            driveTrain = false,
            wheels = false;

    Car(int id) {
        this.id = id;
    }

    synchronized int getId(){
        return id;
    }

    synchronized void addEngine(){
        engine = true;
    }

    synchronized void addDriveTrain(){
        driveTrain = true;
    }

    synchronized void addWheels(){
        wheels = true;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", engine=" + engine +
                ", driveTrain=" + driveTrain +
                ", wheels=" + wheels +
                '}';
    }
}
