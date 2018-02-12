package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.definingTasks;

class BasicThreads {

    public static void main(String[] args) {
//        singleThread();
        multipleThreads();
    }

    private static void multipleThreads(){
        for(int i = 0; i<5; i++){
            new Thread(new LiftOff()).start();
            System.out.println("smultipleThreads");
        }
    }

    private static void singleThread() {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("singleThread");
    }

}
