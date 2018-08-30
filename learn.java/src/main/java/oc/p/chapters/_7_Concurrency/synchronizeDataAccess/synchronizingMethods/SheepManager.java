package oc.p.chapters._7_Concurrency.synchronizeDataAccess.synchronizingMethods;

class SheepManager {

    private int sheepCount = 0;

    static void printDaysWork() {
        synchronized (SheepManager.class) {
            System.out.println("Finished work");
        }
    }

    static synchronized void printDaysWork2(){
        System.out.println("Finished work");
    }

    void incrementAndReport() {
        synchronized (this) {
            System.out.println((++sheepCount) + " ");
        }
    }

    synchronized void incremenetAndReport() {
        System.out.println((++sheepCount) + " ");
    }
}
