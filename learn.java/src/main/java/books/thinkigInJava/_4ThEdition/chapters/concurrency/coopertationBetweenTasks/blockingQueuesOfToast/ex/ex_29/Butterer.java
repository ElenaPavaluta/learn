package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.blockingQueuesOfToast.ex.ex_29;

class Butterer implements Runnable {
    protected Queue toasted;
    protected Queue butterer;

    Butterer(Queue toasted, Queue butterer) {
        this.toasted = toasted;
        this.butterer = butterer;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                SliceOfBread slice = toasted.take();
                slice.setStatus(Status.BUTTER);
                butterer.put(slice);
                System.out.println(slice);
            }
        }catch (InterruptedException e){
            System.out.println("Butterer interrupted");
        }
    }
}
