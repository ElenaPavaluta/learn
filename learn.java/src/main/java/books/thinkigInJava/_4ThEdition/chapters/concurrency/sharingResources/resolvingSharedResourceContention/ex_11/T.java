package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.resolvingSharedResourceContention.ex_11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class T {
    private int odd = 1, even;

    /*synchronized*/ void nextOdd(){
        odd++;
        Thread.yield();
        ++odd;
    }

    /*synchronized */void nextEven(){
        even++;
        Thread.yield();
        ++even;
    }

    void m() throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        IntStream.range(0, 10).forEach(i->{exec.execute(this::nextEven); exec.execute(this::nextOdd);});

        exec.shutdown();
        TimeUnit.MILLISECONDS.sleep(10);
        System.out.println("odd: " + odd);
        System.out.println("even: " + even);
    }

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.m();  //at some point it will print inconsistent data; using synchronize keyword this never happens
    }


}
