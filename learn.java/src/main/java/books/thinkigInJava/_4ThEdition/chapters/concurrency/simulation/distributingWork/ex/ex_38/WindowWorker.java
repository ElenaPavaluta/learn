package books.thinkigInJava._4ThEdition.chapters.concurrency.simulation.distributingWork.ex.ex_38;

class WindowWorker extends Worker {
    @Override
    void work() {
        builder.getHouse().window();
    }

    public WindowWorker(WorkerPool pool) {
        super(pool);
    }
}
