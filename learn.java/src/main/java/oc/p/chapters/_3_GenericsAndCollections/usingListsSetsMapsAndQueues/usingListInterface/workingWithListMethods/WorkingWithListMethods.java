package oc.p.chapters._3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingListInterface.workingWithListMethods;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * boolean	add(E e)
 *
 * void	add(int index, E element)
 *
 * E get(int index)
 *
 * int indexOf(Object o) Returns first matching index or -1 if not found
 *
 * int lastIndexOf(Object o)
 *
 * E remove(int index)
 *
 * E set(int index, E element)
 */
class WorkingWithListMethods {
    static void arrayList() {
        List<String> lst = new ArrayList<>();
        lst.add("0");
        lst.add("b");
        lst.add(null);
        lst.add(1, "a");
        System.out.println(lst.get(1));  //a
        System.out.println(lst.indexOf("c"));  //-1
        System.out.println(lst.lastIndexOf(null));   //3
        String a = lst.remove(1);
        String c = lst.set(2, "c");
        System.out.println(c);  //null
        System.out.println(lst);  //[0, b, c]
        System.out.println(lst.indexOf(LocalDateTime.now()));  //-1
        System.out.println(lst.remove(new ReentrantReadWriteLock()));  //false
    }

    static void linkedList() {
        List<String> lst = new LinkedList<>();

        lst.add(0, "a");
        lst.add(1, "c");
        lst.add(1, "b");
        lst.add("a");

        System.out.println(lst.indexOf("a"));  //0
        System.out.println(lst.lastIndexOf("a"));  //3

        System.out.println(lst.remove(LocalDateTime.now())); //false
        System.out.println(lst.remove(3));  //a

        System.out.println(lst);
    }

    static void vector() {
        List<String> lst = new Vector<>();

        lst.add("a");
        lst.add(1, "b");

        System.out.println(lst.remove(TemporalUnit.class));  //false

        System.out.println(lst.contains(new String("a")));  //true

        System.out.println(lst.size());  //2

        System.out.println(lst);
    }

    static void stack() {
        List<String> lst = new Stack<>();

        lst.add("a");
        lst.add(1, "c");
        lst.add(1, "b");
        lst.add(0, "0");

        System.out.println(lst.size());
        System.out.println(lst);

        System.out.println(lst.remove(ZonedDateTime.now()));  //false
        System.out.println(lst.remove(2));  //b
        System.out.println(lst);
        lst.clear();
        System.out.println(lst.size());  //0
    }

    public static void main(String[] args) {
//        arrayList();
//        linkedList();
//        vector();
        stack();
    }
}
