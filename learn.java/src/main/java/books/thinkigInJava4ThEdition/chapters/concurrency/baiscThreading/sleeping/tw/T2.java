package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.sleeping.tw;

class T2 {

    boolean b = true;

    class A implements Runnable{
        @Override
        public void run() {
            try {
                System.out.println("A run");
                Thread.sleep(5000);
                Thread.currentThread().sleep(5000);
                System.out.println("A run 2");
                b = false;
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void m(){
        new Thread(new A()).start();
        int i = 0;
        while(b){
            System.out.println("m: " + i++);
            try {
//                Thread.sleep(1000);
                Thread.currentThread().sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new T2().m();
    }
}
