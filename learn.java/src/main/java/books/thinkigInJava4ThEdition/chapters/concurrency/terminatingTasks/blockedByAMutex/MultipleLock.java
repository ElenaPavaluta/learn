package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.blockedByAMutex;

class MultipleLock {

    synchronized void f1(int count){
        if(count-- > 0){
            System.out.println("f1() calling f2() with count: " + count);
            f2(count);
        }
    }

    synchronized void f2(int count) {
        if(count-- > 0){
            System.out.println("f2() calling f1() with count: " + count);
            f1(count);
        }
    }

    static void m(){
        final MultipleLock m = new MultipleLock();
        new Thread(){
            @Override
            public void run() {
                m.f1(10);
            }
        }.start();
    }

    public static void main(String[] args) {
        m();
    }
}
