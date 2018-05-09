package books.thinkigInJava._4ThEdition.chapters.concurrency.newLibraryComponents.countDownLatch.tw.p2;

class Buff {

    private String buff= "";

    synchronized void add(String s) {
        buff += " " + s;
    }

    synchronized String get() {
        return buff;
    }
}
