package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.countDownLatch.tw;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Square {
    int n;
    Predicate<Integer> equal0 = i -> i.intValue() == 0;
    Predicate<Integer> equalNminus1 = i -> i.intValue() == n - 1;
    Predicate<Integer> margin = equal0.or(equalNminus1);
    private int x, y, count;
    private List<List<String>> sq;

    public Square(int n) {
        this.n = n;
        sq = Stream
                .<List<String>>generate(() -> Stream.<String>generate(String::new).limit(n).collect(Collectors.toList()))
                .limit(n)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Square s = new Square(5);
        s.set(0, 0);
        System.out.println(s.sq.get(0).get(0));
    }


    synchronized void set(int x, int y) {
        if(margin.test(x) || margin.test(y)) {
            sq.get(x).set(y, "1");
        }
    }

    synchronized void print() {
        if(count < n) {
            System.out.println(sq.get(count++));
        }
    }
}
