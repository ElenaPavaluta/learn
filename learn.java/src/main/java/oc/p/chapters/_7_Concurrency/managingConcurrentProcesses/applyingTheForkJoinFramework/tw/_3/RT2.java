package oc.p.chapters._7_Concurrency.managingConcurrentProcesses.applyingTheForkJoinFramework.tw._3;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

class RT2 {
    public static final int END = Integer.MAX_VALUE;
    public static final int START = 0;
    static int nbProc = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        RT2 r = new RT2();
        r.a();
        r.b();
    }

    void m(Base b) {
        long start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        Long invoke = pool.invoke(b);
        System.out.println(invoke);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    void a() {
        m(new A(START, END));
    }

    void b() {
        m(new B(START, END));
    }

    abstract class Base extends RecursiveTask<Long> {
        final BiPredicate<Integer, Integer> cond = (s, e) -> (e - s) < 20;
        int start;
        int end;

        public Base(int start, int end) {
            this.start = start;
            this.end = end;
        }

        private long getSum() {
            return LongStream.range(start, end).sum();
        }

        @Override
        protected Long compute() {
            if (cond.test(start, end)) {
                return getSum();
            } else {
                return getLong();
            }
        }

        abstract Long getLong();
    }

    class A extends Base {
        public A(int start, int end) {
            super(start, end);
        }

        Long getLong() {
            int middle = start + (end - start) / 2;
            A a = new A(start, middle);
            a.fork();
            return new A(middle, end).compute() + a.join();
        }
    }

    class B extends Base {

        public B(int start, int end) {
            super(start, end);
        }

        @Override
        Long getLong() {
            int part = (end - start) / nbProc;
            List<B> list = IntStream.range(0, nbProc - 1)
                    .mapToObj(i -> new B(start + part * i, start + part * (i + 1)))
                    .collect(toList());
            list.forEach(B::fork);
            Long compute = new B(end - part, end).compute();
            for (B b : list) {
                compute += b.join();
            }
            return compute;
        }
    }
}
