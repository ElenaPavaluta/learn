package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.bounds.wildcardGenericType.wildcards.tw._1;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


class Rmb {

    List rawLst;
    List<Object> objLst;
    List<?> wildcardLst;
    List<? extends A> upperBoundLst;
    List<? super A> lowerBoundLst;

    void setRawLst(){
        rawLst = wildcardLst;
        rawLst = objLst;
        rawLst = upperBoundLst;
        rawLst = lowerBoundLst;
    }

    void setObjLst(){
        objLst = rawLst;

//        objLst is bounded
//        objLst = wildcardLst;  //compiler error

//        objLst = upperBoundLst;
//        objLst = lowerBoundLst;
    }

    void setWildcardLst(){
        wildcardLst = rawLst;
        wildcardLst = objLst;
        wildcardLst = upperBoundLst;
        wildcardLst = lowerBoundLst;
    }

    void setUpperBoundLst(){
        /**
         * ? it works?
         * Backward compatibility ?
         */
        upperBoundLst = rawLst;

//        upperBoundLst = objLst;
//        upperBoundLst = wildcardLst;


        //Because
//        upperBoundLst= new ArrayList<I>();
        upperBoundLst = new ArrayList<>();
        upperBoundLst = new ArrayList<B>();

        lowerBoundLst = new ArrayList<I>();
        lowerBoundLst = new ArrayList<>();
//        lowerBoundLst = new ArrayList<B>();

        /**
         * This doesn't work since there'a non valid
         * combination of assignment
         */
//        upperBoundLst = lowerBoundLst;
    }

    void setLowerBoundLst(){
        //probably due to backward compatibility
        lowerBoundLst = rawLst;

        //Because
        lowerBoundLst = new ArrayList<Object>();
        lowerBoundLst = new ArrayList<I>();
        lowerBoundLst = new ArrayList<>();
        //this works
        lowerBoundLst = objLst;

//        lowerBoundLst = wildcardLst;

//        lowerBoundLst = upperBoundLst;
    }

    void raw(List list){
        list.add(new Integer(1));
        list.add(LocalDate.now());

        list.add(new I(){});
        list.add(new A());
        list.add(new B());
    }

    void lstOfObj(List<Object> list){
        list.add(new Integer(1));
        list.add(LocalDate.now());

        list.add(new I(){});
        list.add(new A());
        list.add(new B());
    }

    void lstOfWildcards(List<?> list){
//        list.add(new Integer(1));
//        list.add(LocalDate.now());

//        list.add(new I(){});

    }

    void listOfUpperBounds(List<? extends A> list){
//        list.add(new A());
//        list.add(new B());
    }

    void listOfLowerBound(List<? super A> list){
        list.add(new A());
        list.add(new B());
//        list.add(new Object());
    }
}



interface I{

}

class A implements I{

}

class B extends A{

}