package books.thinkigInJava._4ThEdition.chapters.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * Wildcards allow covariance
 */
class GenericsAndCovariance {
    static void m(){
        List<? extends Fruit> lst = new ArrayList<Apple>();
        lst = new ArrayList<Orange>();
        lst = new ArrayList<Jonathan>();
        lst = new ArrayList<Fruit>();

        /**
         * Compiler error: can't add any type of object
         *
         * Reason:
         * All the bottom method declarations are legal
         * What would happen in this case:
         * lst = new ArrayList<Orange>();
         * lst.add(new Apple()): would throw a RE exception
         * if the compiler would let this to happen
         * In fact this is the behaviour of the Array
         */
//        lst.add(new Apple());
//        lst.add(new Orange());
//        lst.add(new Fruit());

        lst.add(null);

        lst = new ArrayList<Orange>();
        lst = new ArrayList<Jonathan>();
        lst = new ArrayList<Fruit>();
    }
}
