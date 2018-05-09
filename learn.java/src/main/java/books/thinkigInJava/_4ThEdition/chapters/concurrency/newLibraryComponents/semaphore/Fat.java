package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.semaphore;

class Fat {
    private volatile double d;  //prevent optimisation
    private static int counter = 0;
    private final int id = counter++;

    Fat(){
        //expensive operation
        for(int i=1; i<1000; i++){
            d+=(Math.PI + Math.E)/(double) i;
        }
    }

    void operation(){
        System.out.print(this);
    }

    @Override
    public String toString() {
        return "Fat id: " + id;
    }
}
