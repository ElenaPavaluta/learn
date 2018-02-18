package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.creatingRespobsiveUserInterfaces;

class UnResponsiveUI{
    private volatile double d = 1;

    UnResponsiveUI() throws Exception{
        while(d>0){
            d = d + (Math.PI + Math.E)/d;
        }
        System.in.read();  //never gets here
    }
}
