package oc.p.chapters.c3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingListInterface.comparingListImplementations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**
 * allow null elems
 *
 * equals()
 * Returns true if and only if the specified object is also a list,
 * both lists have the same size, and all corresponding pairs of elements in the two lists are equal.
 * (Two elements e1 and e2 are equal if (e1==null ? e2==null : e1.equals(e2)).)
 *
 * hashCode()
 *
 * toString()
 * (Elements are converted to strings as by String.valueOf(Object))
 */
class ListImplementations {

    ArrayList<String> arrayList = new ArrayList<>();

    LinkedList<String> linkedList = new LinkedList<>();

    Vector<String> vector = new Vector<>();

    Stack<String> stack = new Stack<>();

    void m() {
        arrayList.add("a");
        arrayList.add(null);
        System.out.println(arrayList.hashCode());
        System.out.println(arrayList);
    }

    void m2(){
        linkedList.add("a");
        linkedList.add(null);
        System.out.println(linkedList.hashCode());
        System.out.println(linkedList);
    }

    void m3(){
        vector.add("a");
        vector.add(null);
        System.out.println(vector.hashCode());
        System.out.println(vector);
    }

    void m4(){
        stack.add("a");
        stack.add(null);
        System.out.println(stack.hashCode());
        System.out.println(stack);
    }

    public static void main(String[] args) {
        ListImplementations li = new ListImplementations();

        li.m();
        li.m2();
        li.m3();
        li.m4();
    }
}
