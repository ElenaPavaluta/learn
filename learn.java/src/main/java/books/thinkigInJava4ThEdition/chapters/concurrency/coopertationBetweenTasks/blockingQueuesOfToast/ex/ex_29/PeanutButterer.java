package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.blockingQueuesOfToast.ex.ex_29;

class PeanutButterer extends Butterer  {

    PeanutButterer(Queue toasted, Queue butterer) {
        super(toasted, butterer);
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                SliceOfBread slice = toasted.take();
                slice.setStatus(Status.PEANUT_BUTTER);
                butterer.put(slice);
                System.out.println(slice);
            }
        }catch (InterruptedException e){
            System.out.println("PeanutButterer interrupted");
        }
    }

}
