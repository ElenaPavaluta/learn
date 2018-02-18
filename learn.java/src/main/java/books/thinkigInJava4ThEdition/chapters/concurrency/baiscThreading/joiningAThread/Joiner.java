package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.joiningAThread;

class Joiner extends Thread {
    Sleeper sleeper;

    Joiner(String name, Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch(InterruptedException e) {
            System.out.println(getName() + "interruptd");
        }
        System.out.println(getName() + " join completed");
    }
}
