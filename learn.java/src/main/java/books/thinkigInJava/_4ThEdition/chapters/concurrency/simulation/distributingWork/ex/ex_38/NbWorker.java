package books.thinkigInJava._4ThEdition.chapters.concurrency.simulation.distributingWork.ex.ex_38;

class NbWorker extends Worker {
    public NbWorker(WorkerPool pool) {
        super(pool);
    }

    @Override
    void work() {
        builder.getHouse().nb();
    }
}
