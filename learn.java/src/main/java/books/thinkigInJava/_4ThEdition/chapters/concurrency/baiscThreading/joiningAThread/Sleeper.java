package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.joiningAThread;

class Sleeper extends Thread {
    int duration;

    Sleeper(String name, int duration){
        super(name);
        this.duration = duration;
        start();
    }

    /**
     * The catch block clears the isInterrupted flog (sets is to false)
     */
    @Override
    public void run() {
        try {
            sleep(duration);
        } catch(InterruptedException e) {
            System.out.println(getName() + " was interrupted. isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");
    }
}
