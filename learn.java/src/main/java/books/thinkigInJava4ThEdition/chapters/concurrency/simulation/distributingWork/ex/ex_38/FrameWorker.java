package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.distributingWork.ex.ex_38;

class FrameWorker extends Worker {
    public FrameWorker(WorkerPool pool) {
        super(pool);
    }

    @Override
    void work() {
        builder.getHouse().frame();
    }
}
