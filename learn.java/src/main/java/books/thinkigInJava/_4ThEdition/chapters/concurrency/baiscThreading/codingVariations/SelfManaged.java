package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.codingVariations;

class SelfManaged implements Runnable {

    int countDown = 5;
    Thread t = new Thread(this);

    SelfManaged() {
        t.start();
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() + "(" + countDown + ")";
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
        for(int i=0; i<5; i++){
            new SelfManaged();
        }
    }
}
