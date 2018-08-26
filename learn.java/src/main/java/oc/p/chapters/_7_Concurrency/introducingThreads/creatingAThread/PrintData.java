package oc.p.chapters._7_Concurrency.introducingThreads.creatingAThread;

class PrintData implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.println("record: " + i);
        }
    }

    public static void main(String[] args) {
        new Thread(new PrintData()).start();
    }
}

class ReadInventoryThread extends Thread {
    @Override
    public void run() {
        System.out.println("Printing zoo inventory");
    }

    public static void main(String[] args) {
        new ReadInventoryThread().start();
    }
}

class Random {
    public static void main(String[] args) {
        System.out.println("begin");
        (new ReadInventoryThread()).start();
        (new Thread(new PrintData())).start();
        (new ReadInventoryThread()).start();
        System.out.println("end");
    }
}
