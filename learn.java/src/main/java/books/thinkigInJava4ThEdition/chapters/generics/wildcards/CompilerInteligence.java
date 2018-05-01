package books.thinkigInJava4ThEdition.chapters.generics.wildcards;

import java.util.LinkedList;
import java.util.List;

class CompilerInteligence {

    static void m(){
        List<Apple> apples = new LinkedList<>();
        apples.add(new Apple());
        apples.add(new Jonathan());

        List<? extends Fruit> lst = apples;
//        lst.add(new Apple());  //compiler error

        Apple a = (Apple) lst.get(0);

        /**
         * boolean contains(Object o)
         */
        System.out.println(lst.contains(a));

        /**
         * int indexOf(Object o)
         */
        System.out.println(lst.indexOf(a));
    }

    public static void main(String[] args) {
        m();
    }
}
