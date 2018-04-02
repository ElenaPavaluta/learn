package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.distributingWork.ex.ex_38;

class RoofWorker extends Worker {
    @Override
    void work() {
        builder.getHouse().roof();
    }

    public RoofWorker(WorkerPool pool) {
        super(pool);
    }
}
