package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.exchanger;

import java.util.stream.DoubleStream;

class Expensive {

    private double d;

    Expensive(){
        d = DoubleStream
                .iterate(1, temp-> Math.PI*Math.E/Math.random())
                .distinct()
                .limit(100)
                .summaryStatistics()
                .getAverage();
    }

    public double getD() {
        return d;
    }

    @Override
    public String toString() {
        return "Expensive{" +
                "d=" + d +
                '}';
    }
}
