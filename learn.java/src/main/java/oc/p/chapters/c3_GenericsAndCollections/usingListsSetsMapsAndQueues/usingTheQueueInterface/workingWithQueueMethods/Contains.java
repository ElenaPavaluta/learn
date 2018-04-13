package oc.p.chapters.c3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingTheQueueInterface.workingWithQueueMethods;

import java.util.*;

class Contains {

    static void arrayList(){
        List<String> lst = Arrays.asList("1", "2", null);
        System.out.println(lst.contains("1"));  //true
        System.out.println(lst.contains(null));  //true
    }

    static void vector(){
        Vector<String> vector = new Vector<>();
        vector.add("1");
        vector.add(null);
        System.out.println(vector);
        System.out.println(vector.contains("2"));  //false
        System.out.println(vector.contains(null));  //true
    }

    static void stack(){
        Stack<String> s = new Stack<>();
        System.out.println(s.push("1"));  //1
        System.out.println(s.push(null));  //null
        System.out.println(s.contains(null));  //true
        System.out.println(s.contains("1"));  //true
        System.out.println(s);
    }

    static void linkedList(){
        LinkedList<String> l = new LinkedList<>();
        System.out.println(l.add("1"));  //true
       l.push(null);  //the return type is void
        System.out.println(l.contains(null));  //true
        System.out.println(l.contains("1"));  //true
        System.out.println(l);  //[null, 1]
    }

    static void hashSet(){
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add(null);
        System.out.println(set.contains(null));  //true
        System.out.println(set.contains("1"));  //true
    }

    static void treeSet(){
        Set<String> set = new TreeSet<>();
        set.add("1");
//        set.add(null);  //RE: NPE
//        System.out.println(set.contains(null));  //RE: NPE
    }

    static void arrayDeque(){
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
//        System.out.println(arrayDeque.add(null));  //RE: NPE
        arrayDeque.push("1");
//        arrayDeque.push(null);  //NPE
        System.out.println(arrayDeque.contains(null));  //false
        System.out.println(arrayDeque.contains("1"));  //true
        System.out.println(arrayDeque);  //[1, null]
    }

    public static void main(String[] args) {
//        arrayList();
//        vector();
//        stack();
//        linkedList();
//        hashSet();
//        treeSet();
        arrayDeque();
    }
}
