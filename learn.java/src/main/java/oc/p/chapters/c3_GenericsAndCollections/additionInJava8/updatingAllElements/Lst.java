package oc.p.chapters.c3_GenericsAndCollections.additionInJava8.updatingAllElements;

import java.util.Arrays;
import java.util.List;

/**
 * This method is specific to List interface
 *
 * default void	replaceAll(UnaryOperator<E> operator)
 */
class Lst {

    static void m(){
        List<String> lst = Arrays.asList("ana", "are", "ananas");
        lst.replaceAll(s->s.replace('a', 'A'));
        System.out.println(lst);
    }

    public static void main(String[] args) {
        m();
    }
}
