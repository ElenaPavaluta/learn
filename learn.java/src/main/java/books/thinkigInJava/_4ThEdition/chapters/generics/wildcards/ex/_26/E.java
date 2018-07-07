package books.thinkigInJava._4ThEdition.chapters.generics.wildcards.ex._26;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

class E {

    static Number[] array;

    static void m() {
        array = new Number[5];
        array[0] = new Integer(0);
        array[1] = new Long(1);
        array[2] = new Float(2);
        array[3] = new Double(3);
        array[4] = new AtomicInteger(4);

        System.out.println(Arrays.toString(array));
    }

    static void m2() {
        /**
         * Although the reference is of dbType Number[}
         * the actual dbType is Integer[]
         * which means that any dbType of Number can be added,
         * but anything added besides Integers will generate a RE
         */
        array = new Integer[5];

        array[0] = new Integer(0);

        /**
         * All the bellow assignment are compile time legal,
         * but at run-time generate a RE
         */
//        array[1] = new Long(1);
//        array[2] = new Float(2);
//        array[3] = new Double(3);
//        array[4] = new AtomicInteger(4);

        System.out.println(Arrays.toString(array));
    }


    public static void main(String[] args) {
//        m();
        m2();
    }

}
