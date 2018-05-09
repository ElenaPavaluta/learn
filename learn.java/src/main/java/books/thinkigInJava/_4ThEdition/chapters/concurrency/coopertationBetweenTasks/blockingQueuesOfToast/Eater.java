package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.blockingQueuesOfToast;

class Eater implements Runnable {
    private ToastQueue queue;
    private int counter;

    public Eater(ToastQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                Toast t = queue.take();
                if(t.getId() != counter ++ || t.getStatus()!= Toast.Status.JAMED){
                    System.out.println("Error: " + t);
                    System.exit(1);
                }else{
                    System.out.println("Chomp: " + t);
                }
            }
        }catch(InterruptedException e){
            System.out.println("Eater interrupted");
        }
        System.out.println("Eater off");
    }
}
