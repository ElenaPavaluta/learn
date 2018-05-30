package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.genericClasses;

import oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.Elephant;
import oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.Robot;

/**
 * Type Erasure
 * <p>
 * Specifying a generic type allows the compiler to enforce proper use of the generic type.
 * For example, specifying the generic type of Crate as Robot is like replacing the T in the
 * Crate class with Robot. However, this is just for compile time.
 * Behind the scenes, the compiler replaces all references to T in Crate with Object. In other
 * words, after the code compiles, your generics are actually just Object types.
 */
class TypeErasure {

    public static void main(String[] args) {
        Crate<Robot> cr = new Crate<> ( );
        cr.pack ( new Robot ( ) );
        Robot r = cr.unPack ( );
        /*
        Behind the scene, the cast is automatically done
        Robot r = (Robot)cr.unPack ();
         */

//        cr.pack ( new Elephant () );  //compiler error
//        cr = new Crate<Elephant> ();  //compiler error

        Crate<Elephant> ce = new Crate<> ( );
        ce.pack ( new Elephant ( ) );
        Elephant e = ce.unPack ( );
    }

}
