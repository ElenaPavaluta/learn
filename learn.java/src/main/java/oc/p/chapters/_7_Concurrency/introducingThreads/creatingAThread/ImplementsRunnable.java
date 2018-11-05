package oc.p.chapters._7_Concurrency.introducingThreads.creatingAThread;

import utils.delimitators.Delimitators;

class ImplementsRunnable implements Runnable {
    public static void main(String[] args) {
        new Thread().start();
        Delimitators.equal();
        new Thread(new ImplementsRunnable()).start();
    }

    @Override
    public void run() {
        System.out.println("ImplementsRunnable");
    }
}

