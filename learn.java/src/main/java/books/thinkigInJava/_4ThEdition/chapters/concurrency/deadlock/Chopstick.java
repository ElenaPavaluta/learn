package books.thinkigInJava._4ThEdition.chapters.concurrency.deadlock;

import sun.plugin.viewer.context.IExplorerAppletContext;

class Chopstick {

    private boolean taken = false;

    synchronized void take() throws InterruptedException{
        while (taken){
            wait();
        }
        taken = true;
    }

    synchronized void drop(){
        taken = false;
        notifyAll();
    }
}
