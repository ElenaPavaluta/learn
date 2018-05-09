package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.tw.p5;

class C {

    private volatile String s;

    void m() {
        System.out.println(s);
    }

    void m2() {
        s = s + " a";
    }
}
