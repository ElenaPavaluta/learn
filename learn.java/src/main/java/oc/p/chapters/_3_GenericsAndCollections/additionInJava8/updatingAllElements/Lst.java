package oc.p.chapters._3_GenericsAndCollections.additionInJava8.updatingAllElements;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

/**
 * This method is specific to List interface
 *
 * default void	replaceAll(UnaryOperator<E> operator)
 */
class Lst {

    static void m() {
        List<String> lst = Arrays.asList("ana", "are", "ananas");
        lst.replaceAll(s -> s.replace('a', 'A'));
        System.out.println(lst);
    }


    static void m2() {
        List<Integer> lst = getIntegers();
        lst.replaceAll(i->i*7);
        System.out.println(lst.removeIf(i->i%5==0));
        lst.forEach(System.out::println);
    }

    private static List<Integer> getIntegers() {
        return IntStream.rangeClosed(1, 5)
                        .mapToObj(i -> i)
                        .collect(toCollection(LinkedList::new));
    }

    static void m3(){
        List<Integer> lst = getIntegers();
        lst.replaceAll(null);  //NPE
    }

    public static void main(String[] args) {
        m();
        m2();
        m3();
    }
}
