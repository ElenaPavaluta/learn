package oc.p.chapters._3_GenericsAndCollections.additionInJava8.removingConditionally;

import java.util.*;

/**
 * default boolean	removeIf(Predicate<? super E> filter)
 */
class RemovingConditionally {

    class A implements Comparable{
        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    static void m(){
        Collection<String> c = new HashSet<>();
        c.removeIf(s->s.equals(""));

        Map<Integer, Integer> map = new TreeMap<>();
        map.remove(1);
        map.remove(new RemovingConditionally(). new A());

        /**
         * RE: ClassCastException:  due to the fact that
         * the Object doesn't implement the Comparable interface
         */
//        map.remove(new Object());
        map.remove(1, 1);
//        map.removeIf();  //Map doesn't have the removeIf method
    }

    public static void main(String[] args) {
        m();
    }
}
