package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.bounds.wildcardGenericType.wildcards.bound.upper.tw;

import oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.Robot;
import oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.Robot2;
import java.util.ArrayList;
import java.util.List;

class UB {

    Robot[] ar;
    Robot2[] ar2;

    List<Robot> lb;
    List<Robot2> lb2;

    List<? extends Robot> leb;
    List<? extends Robot2> leb2;

    {
        ar = new Robot[3];
        ar[0] = new Robot();
        ar[1] = new Robot2();

        ar2 = new Robot2[3];
        ar2[0] = new Robot2();

        Object[] oa;
        oa = ar2;

        ar = ar2;
//        ar2 = ar;  //compiler error
    }

    {
//        lb = new ArrayList<Robot2>();  //compiler error
        lb = new ArrayList<>();
        lb = new ArrayList<Robot>();
        lb.add(new Robot2());
        lb.add(new Robot());
    }

    {
//        lb2 = (List<Robot>)new ArrayList<Robot>();
        lb2 = new ArrayList<>();
        lb2 = new ArrayList<Robot2>();
        lb2.add(new Robot2());
//        lb2.add((Robot2)new Robot());  //RE - ClassCastException
    }

    {
        leb  = new ArrayList<>();
//        leb.add(new Robot());  //compiler error: immutable for the add operation
//        leb.add(new Robot2());

        leb = new ArrayList<Robot2>();

        leb = lb;
        leb = leb2;
    }

    {
//        leb2 = new ArrayList<Robot>();  //compiler error

        leb2  = new ArrayList<>();

//        leb2 = lb  //compiler error
        leb2 = lb2;
    }

    public static void main(String[] args) {
        new UB();
    }



}
