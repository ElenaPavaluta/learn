package books.thinkigInJava._4ThEdition.chapters.generics.wildcards;

class WildcardsRepeat {

    static void rawArgs(Holder holder, Object obj){
        holder.setT(obj);  //warning
        holder.setT(new WildcardsRepeat());  //warning

//        T t = holder.getT();  //mo T
        Object o = holder.getT();
    }

    static void unboundedArg(Holder<?> hoder, Object obj){
        /**
         * Holder<?> means that is Holder of some dbType object,
         * although unknown this dbType of object at this point
         * Similar to List<?>. Of course this ? is an object at
         * runtime, but we're at compile time, now
         *
         * Holder
         */
//        hoder.setT(obj);  //

     Object o = hoder.getT();

     hoder = new Holder<Integer>();
//     hoder.setT(new Integer(2));  //compiler error, samae as List<?>
    }

    static <T> T exact(Holder<T> holder){
        T t2 = holder.getT();
        return t2;
    }

    static <T> T exact2(Holder<T> holder, T t){
        holder.setT(t);
        T t2 = holder.getT();
        return t2;
    }

    static <T> void wildSubType(Holder<? extends T> holder, T t){
        /**
         * Compiler error:
         * Same as List<? extends T>
         * Can't really know what dbType of object is ? extend T.
         * It could be T or a subtype of T, as the definition tells.
         */
//        holder.setT(t);

        /**
         * This is legal
         *
         * Doesn't really matter the dbType of object reprezented by
         * ? extends T, since it will always be at least T
         */
        T t2 = holder.getT();
    }


    static <T> void wildSuperType(Holder<? super T> holder, T t){
        /**
         * This is legal
         * Same as List<? super T>
         *
         * The holder can contain any dbType of object as long as it is
         * either T or any class/ interface T extends/implements
         */
        holder.setT(t);

        /**
         * Compiler error
         *
         * Imagine U as being a class that T extends and
         * U is in fact the  dbType contained by Holder.
         *
         * What would happen when the JVM will try to cast U to T?
         *
         * That's wright: ClassCastException, So the compiler
         * forbids this by rasing a compiler error
         */
//        T t2 = holder.getT();

        /**
         * Legal, since object is the parent of all object in javas
         */
        Object o = holder.getT();
    }

    public static void main(String[] args) {
        Holder raw = new Holder();
        raw = new Holder<Long>();

        Holder<Long> qualified = new Holder<>();

        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();

        Long l = 1L;

        rawArgs(raw, l);
        rawArgs(qualified, l);
        rawArgs(unbounded, l);
        rawArgs(bounded, l);

        unboundedArg(raw, l);
        unboundedArg(qualified, l);
        unboundedArg(unbounded, l);
        unboundedArg(bounded, l);

        Object o = exact(raw);
        Long l2 = exact(qualified);
        Object o2 = exact(unbounded);
        Long l3 = exact(bounded);

        Long l4 = exact2(raw, l);
        Long l5 = exact2(qualified, l);

//        Object o3 =  exact2(unbounded, new Object());
        Object o3 =  exact2(unbounded, null);
//        Long l6 = exact2(bounded, l);
        Long l6 = exact2(bounded, null);

        wildSubType(raw, new Object());
        wildSubType(qualified, l);
        wildSubType(unbounded, l);
        wildSubType(bounded, l);

        wildSuperType(raw, new Object());
        wildSuperType(qualified, l);

//        wildSuperType(unbounded, l);
//        wildSuperType(unbounded, new Object());
//        wildSuperType(unbounded, null);

//        wildSuperType(unbounded, l);
//        wildSuperType(unbounded, new Object());
//        wildSuperType(bounded, null);
    }
}
