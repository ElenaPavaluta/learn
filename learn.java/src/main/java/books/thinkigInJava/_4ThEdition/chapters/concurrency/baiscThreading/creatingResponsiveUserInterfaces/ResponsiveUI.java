package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.creatingResponsiveUserInterfaces;

class ResponsiveUI extends Thread{

    static volatile double d = 1;

    ResponsiveUI(){
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while(true){
            d = d + (Math.PI + Math.E)/d;
        }
    }

    public static void main(String[] args) throws Exception {
//        new UnResponsiveUI();   //run forever: must kill this process

        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
