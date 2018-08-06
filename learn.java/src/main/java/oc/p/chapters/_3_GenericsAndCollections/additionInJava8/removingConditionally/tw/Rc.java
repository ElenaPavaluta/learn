package oc.p.chapters._3_GenericsAndCollections.additionInJava8.removingConditionally.tw;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

class Rc {

    Deque<Integer> dq;

    {
        dq = IntStream.range(0, 10)
                      .mapToObj(i -> i)
                      .collect(toCollection(LinkedList::new));
    }

    void m(){
        System.out.println(dq.removeIf(i->i%2==0));
        print();

        System.out.println(dq.removeIf(i->i>10));
        print();

        System.out.println(dq.removeIf(i->i%3==0));
        print();
    }

    void m2(){
        dq.removeIf(null);  //NPE
    }

    private void print() {
        dq.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Rc rc = new Rc();
        rc.m();
        rc.m2();
    }
}
