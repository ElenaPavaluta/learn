package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.bounds.wildcardGenericType.wildcards.tw._2;

import java.time.LocalDate;
import java.util.List;

class Rmb {

    List rawList;
    List<Object> objectList;
    List<?> wildcardList;
    List<? extends A> upperBoundList;
    List<? super A> lowerBoundList;


    void m(){
        rawList = objectList;
        rawList = wildcardList;
        rawList = upperBoundList;
        rawList = lowerBoundList;
    }

    void m2(){
        objectList = rawList;
//        objectList = wildcardList;
//        objectList = upperBoundList;
//        objectList = lowerBoundList;
    }

    void m3(){
        wildcardList = rawList;
        wildcardList = objectList;
        wildcardList = upperBoundList;
        wildcardList = lowerBoundList;
    }

    void m4(){
        upperBoundList = rawList;
//        upperBoundList = objectList;
//        upperBoundList = wildcardList;
//        upperBoundList = lowerBoundList;
    }

    void m5(){
        lowerBoundList = rawList;
        lowerBoundList = objectList;
//        lowerBoundList = wildcardList;
//        lowerBoundList = upperBoundList;
    }

    void m6(){
        rawList.add(new A());
        rawList.add(LocalDate.now());
    }

    void m7(){
        objectList.add(new Object());
        objectList.add(new A());
        objectList.add(LocalDate.now());
    }

    void m8(){
//        wildcardList.add(new Object());
//        wildcardList.add(new A());
//        wildcardList.add(LocalDate.now());
    }

    void m9(){
//        upperBoundList.add(new Object());
//        upperBoundList.add(new I(){});
//        upperBoundList.add(new A());
//        upperBoundList.add(new B());
    }

    void m10(){
//        lowerBoundList.add(new Object());
//        lowerBoundList.add(new I(){});
        lowerBoundList.add(new A());
        lowerBoundList.add(new B());
    }


interface I{}

class A implements I{}

class B extends A{}
}
