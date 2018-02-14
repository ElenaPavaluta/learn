package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.codingVariations;

class SimpleThread extends Thread{

    int countDown = 5;
    static int threadCount = 0;

    SimpleThread(){
        super(Integer.toString(++threadCount));
        start();
    }

    @Override
    public String toString() {
        return "SimpleThread: " + Thread.currentThread().getId() +
                "{countDown=" + countDown +
                '}';
    }

    @Override
    public void run() {
        while(true){
            System.out.println(this);
            if(--countDown==0){
                return;
            }
        }
    }

    public static void main(String[] args) {
        for(int i= 0; i<5; i++){
            new SimpleThread();
        }
    }
}
