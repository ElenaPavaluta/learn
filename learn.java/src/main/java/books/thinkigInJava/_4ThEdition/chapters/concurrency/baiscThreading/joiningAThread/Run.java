package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.joiningAThread;

class Run {

    static void m(){
        Sleeper sleepy = new Sleeper("Sleepy", 1500),
                grumpy = new Sleeper("Grumpy", 1500);

        Joiner dopey = new Joiner("Dopey", sleepy),
                doc = new Joiner("Doc", grumpy);

        System.out.println(grumpy.isInterrupted());
        grumpy.interrupt();
        System.out.println(grumpy.isInterrupted());
    }

    public static void main(String[] args) {
        m();
    }
}
