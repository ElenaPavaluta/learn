package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.cantDoWithGenerics;

class NA2<T> {

//    T t = new T();  //compiler error

    T[] ta;

    {
//        ta = new T[3];  //compiler error
//        ta = new T[]{};  //compiler error
//        ta = {};  //compiler error

        ta = (T[])new Object[2];
        ta = (T[])new String[2];

    }

//    static T t;  //compiler error: the type T is linked to the instance of the class

    void m(T t){
//        boolean b = t instanceof List<T>;  //compiler error
    }
}
