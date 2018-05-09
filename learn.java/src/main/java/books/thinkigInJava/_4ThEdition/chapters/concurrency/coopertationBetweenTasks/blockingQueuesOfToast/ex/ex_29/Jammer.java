package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.blockingQueuesOfToast.ex.ex_29;

class Jammer implements Runnable {
    private Queue buttered;
    private Queue finished;

    Jammer(Queue buttered, Queue finished) {
        this.buttered = buttered;
        this.finished = finished;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                SliceOfBread slice = buttered.take();
                slice.setStatus(Status.JAM);
                finished.put(slice);
                System.out.println(slice);
            }
        }catch (InterruptedException e){
            System.out.println("Jammer interrupted");
        }
    }
}
