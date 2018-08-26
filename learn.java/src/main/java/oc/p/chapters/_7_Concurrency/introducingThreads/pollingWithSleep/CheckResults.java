package oc.p.chapters._7_Concurrency.introducingThreads.pollingWithSleep;

class CheckResults {

    private static int counter = 0;

    static void m() throws InterruptedException {
        new Thread(
                ()->{
                    for(int i=0; i<500; i++)CheckResults.counter++;
                }
        ).start();

        while(CheckResults.counter < 100){
            System.out.println("Not reached yet");
            Thread.sleep(1000);
        }
        System.out.println("Reached");
    }

    public static void main(String[] args) throws InterruptedException {
        m();
    }
}
