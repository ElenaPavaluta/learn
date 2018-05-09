package books.thinkigInJava._4ThEdition.chapters.concurrency.simulation.distributingWork.ex.ex_38;

class DoorWorker extends Worker {
    public DoorWorker(WorkerPool pool) {
        super(pool);
    }

    @Override
    void work() {
        builder.getHouse().door();
    }
}
