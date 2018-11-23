package oc.p.tests.chapters._20.q._2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class TicketTaker {
    final AtomicInteger ticketsTaken;
    long ticketsSold;

    TicketTaker() {
        ticketsSold = 0;
        ticketsTaken = new AtomicInteger(0);
    }

    public static void main(String[] args) {
        TicketTaker tt = new TicketTaker();
        tt.performJob();
    }

    void performJob() {
        IntStream.iterate(1, p -> p + 1)
                .parallel()
                .limit(10)
                .forEach(i -> ticketsTaken.getAndIncrement());
        IntStream.iterate(1, q -> q + 1)
                .limit(5)
                .parallel()
                .forEach(i -> ++ticketsSold);

        System.out.println(ticketsTaken + " " + ticketsSold);
    }
}
