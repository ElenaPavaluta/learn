package books.thinkigInJava._4ThEdition.chapters.generics.wildcards;

import oc.a.chapters.c1_building_blocks.pkg_declaration_and_imports.wildcard.Wildcard;
import java.util.ArrayList;
import java.util.List;

class Wildcards {

    static void rawArgs(Holder holder, Object obj) {
        holder.setT(obj);  //warning
        holder.setT(new Wildcards()); //warning

//        T t = holder.getT();  //RE: we don't have t
        Object o = holder.getT();
    }

    static void unboundedArgs(Holder<?> holder, Object obj) {
        /**
         * Compiler error
         *
         * ? means that we don't know the type
         * putting Objec doen't solve the issue
         */
//        holder.setT(obj);
//        holder.setT(new Wildcards());

        holder = new Holder<Wildcard>(new Wildcard());

        /**
         * The refence type is Holder<?> which means
         * that is a Holder of some unspecified object
         *
         * Holder is a holder of object
         */
//        holder.setT(new Wildcards());>

        Object o = holder.getT();

        /**
         * Although the cast eliminated the compiler error, it will
         * still a RE since no element can be added using the reference
         * (only by assigning an Holder<T> object is which the T elem
         * has be set prior to assignent)
         */
        Wildcard w = (Wildcard) holder.getT();
    }

    static <T> T exact(Holder<T> holder) {
        T t = holder.getT();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T t) {
        holder.setT(t);
        t = holder.getT();
        return t;
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        /**
         * Same thing as List<? extends T>: cannot add any new elememt
         * but to the reference a List of subtype can be assigned
         */
//        holder.setT(arg);
        holder = new Holder<T>(arg);
//        holder.setT(new Wildcards());  //same compiler error, as above

        T t = holder.getT();
        return t;
    }

    static <T> T wildSupertype(Holder<? super T> holder, T arg) {
        /**
         * Once again: same as List<? super T>
         */
        holder.setT(arg);
        T t = (T) holder.getT();


        List<? super T> lst = new ArrayList<Object>();
        T t2 = (T) lst.get(0);

        return t;
    }
}
