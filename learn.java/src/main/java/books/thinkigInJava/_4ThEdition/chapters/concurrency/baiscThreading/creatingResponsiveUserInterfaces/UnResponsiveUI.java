package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.creatingResponsiveUserInterfaces;

class UnResponsiveUI{
    private volatile double d = 1;

    UnResponsiveUI() throws Exception{
        while(d>0){
            d = d + (Math.PI + Math.E)/d;
        }
        System.in.read();  //never gets here
    }
}
