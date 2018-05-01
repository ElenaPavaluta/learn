package books.thinkigInJava4ThEdition.chapters.generics.wildcards.ex._27;

import org.omg.PortableInterceptor.INACTIVE;
import java.util.*;

class E {
    
    static List<Number> lst;
    static List<? extends Number> lst2;
    
    static void m(){
        lst = new ArrayList<>();
        lst.add(new Integer(0));
        lst.add(new Long(1));
        lst.add(new Float(3));
        lst.add(new Double(4));
        System.out.println(lst);
    }

    static void m2(){
        /**
         * Compiler error:
         */
//        lst = new ArrayList<Integer>();
//        lst = new ArrayList<Long>();
//        lst = new LinkedList<Float>();
//        lst = new Vector<Double>();
    }

    static void m3(){
        lst2 = new ArrayList<Integer>();
        /**
         * Compiler error:
         * how can the compiler know the exact type of objects
         * contained by the ArraysList,
         * so in order to avoid a RE, just doesn't permit adding
         * any new element, except null (probably just for the
         * collection which allow null)
         *
         * Remember collection which don't allow null elems:
         * TreeSet
         * TreeMap - no null keys
         * ArrayDeque - due to special methods poll (and peek?)
         * hashtable - old Map implemetation
         */
//        lst2.add(new Integer(0));
//        lst2.add(new Long(1));
    }

    static void m4(){
        lst2 = new ArrayList<Integer>();
        lst2 = new LinkedList<Long>();
        lst2 = new Vector<Float>();
        lst2 = new Stack<Double>();
    }

    public static void main(String[] args) {
        m();
    }
}
