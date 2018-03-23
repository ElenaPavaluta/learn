package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.bankTellerSimulation;


//Read only objects don't require synchronisation
class Customer {

    private final int serviceTime;

    Customer(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public String toString() {
        return "[" + serviceTime + "]";
    }

}
