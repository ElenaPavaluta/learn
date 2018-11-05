package oc.p.chapters._7_Concurrency.introducingThreads.creatingAThread;

import utils.print.Print;

class ExtendThread extends Thread {

    public static void main(String[] args) {
        Thread t = new ExtendThread();
        Thread t2 = new ExtendThreadOverrideRun();
        System.out.println("ExtendThread id: " + t.getId());
        System.out.println("ExtendThreadOverrideRun id: " + t2.getId());
        System.out.println("Main Thread id: " + Thread.currentThread().getId());

        Print.Delimitators.equal();
        t.start();
        Print.Delimitators.equal();
        t2.start();
    }
}

class ExtendThreadOverrideRun extends Thread {
    @Override
    public void run() {
        System.out.println("ExtendThreadOverrideRun");
    }
}
