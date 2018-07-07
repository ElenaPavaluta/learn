package books.thinkigInJava._4ThEdition.chapters.generics.compensatingForErasure.arraysOfGenerics.tw.genericArray;

class C2 {

    static String[] sa;

    static void m() {
        System.out.println(sa instanceof String[]);  //false: null instanceof Object
        System.out.println(sa instanceof Object[]); //false
//        System.out.println(sa instanceof LocalDateTime[]);  //compiler error
        /**
         * String is a final class, so no subclass of String (can't be subclassed)
         * can also implement I, so: compiler error
         */
//         System.out.println(sa instanceof I[]);
    }

    static void m2() {
        /**
         * Arrays keep track of their actual dbType
         * which is established at runtime
         */
        sa = (String[]) new Object[5];  //ClassCastException
    }

    static void m3() {
        sa = new String[5]; //the actual dbType is String
        Object[] oa = sa;  //A String is also an object
        sa = (String[]) oa;  //since the actual dbType is String, this cast is safe
    }

    public static void main(String[] args) {
//        createAndPopulate();
        m2();
//        m3();
    }

    interface I {

    }
}
