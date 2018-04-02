package oc.p.chapters.c3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingListInterface.workingWithListMethods;

import java.util.ArrayList;
import java.util.List;

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
    static void m(){
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
    }

    public static void main(String[] args) {
        m();
    }
}
