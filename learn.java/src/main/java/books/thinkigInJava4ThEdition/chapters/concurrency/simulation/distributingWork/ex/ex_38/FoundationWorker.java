package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.distributingWork.ex.ex_38;

class FoundationWorker extends Worker {
    public FoundationWorker(WorkerPool pool) {
        super(pool);
    }

    @Override
    void work() {
        builder.getHouse().foundation();
    }
}
