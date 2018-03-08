package books.thinkigInJava4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.tw.p5;

class C {

    private volatile String s;

    void m() {
        s = "m";
        System.out.println(s);
    }

    void m2() {
        s = s + " a";
    }
}
