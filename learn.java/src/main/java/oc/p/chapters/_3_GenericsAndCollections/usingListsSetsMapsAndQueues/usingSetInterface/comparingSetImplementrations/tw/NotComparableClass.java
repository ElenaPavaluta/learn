package oc.p.chapters._3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingSetInterface.comparingSetImplementrations.tw;

import java.util.TreeSet;

class NotComparableClass {

    {
        System.out.println("this is not a comparable class");
    }

    public static void main(String[] args) {

        TreeSet<NotComparableClass> tree = new TreeSet<>();
        tree.add(new NotComparableClass());  //RE: ClassCastException
    }

}
