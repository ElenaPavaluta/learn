package oc.p.tests.chapters._20.q._32;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class Line {

    static void m(){
        BlockingDeque<Integer> queue = new LinkedBlockingDeque <>();

        IntStream.iterate(1, i->i+1)
                .limit(5)
                .parallel()
                .forEach(s-> {
                    try {
                        queue.offerLast(s, 10000, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                    }
                });

        IntStream.iterate(1, i->i+1)
                .limit(10)
                .parallel()
                .forEach(s-> {
                    try {
                        queue.pollFirst(10, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                    }
                });
        System.out.println(queue.size());
    }

    public static void main(String[] args) {
        m();
    }
}
