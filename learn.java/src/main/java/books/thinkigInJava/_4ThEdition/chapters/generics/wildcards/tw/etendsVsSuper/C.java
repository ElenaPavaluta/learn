package books.thinkigInJava._4ThEdition.chapters.generics.wildcards.tw.etendsVsSuper;

import utils.javaClass.hierrarchy.methods.none.fruit.*;
import java.time.LocalDateTime;
import java.util.*;

class C {

    static List lst;
    static List<?> lstOfQ;
    static List<Apple> lstOfApples;
    static List<? extends Apple> lstExtendsApple;
    static List<? super Apple> lstSuperApple;

    static void m(){
        lst = new ArrayList();
        lst = new LinkedList<LocalDateTime>();
        lst.add(new Apple());
    }

    static void m2(){
        lstOfQ = new ArrayList<Apple>();
        lstOfQ = new LinkedList<Fruit>();
        lstOfQ  =new Vector<Orange>();

        /**
         * Compiler error:
         * The compiler can't know the actual dbType of
         * object in the collection so, in order
         * to avoid a ClassCastException forbids the adding
         * functionality
         */
//        lstOfQ.add(new Orange());
    }

    static void m3(){
        lstOfApples = new ArrayList<>();
//        lstOfApples = new LinkedList<GoldApple>(); //compiler error
//        lstOfApples = new Vector<Fruit>();

        lstOfApples.add(new Apple());
        lstOfApples.add(new GoldApple());
        lstOfApples.add(new SilverApple());

//        lstOfApples.add(new Fruit())  //compiler error
    }

    static void m4() {
        lstExtendsApple = new ArrayList<Apple>();  //default dbType
        lstExtendsApple = new LinkedList<GoldApple>();
        lstExtendsApple = new Vector<SilverApple>();
//        lstExtendsApple = new Stack<Fruit>();
//        lstExtendsApple = new Vector<Object>();  //compiler error

        /**
         * Compiler error
         * can't add new element because the compiler
         * can't possible know the actual dbType contained
         * in the collection
         */
//        lstExtendsApple.add(new Apple());
//        lstExtendsApple.add(new GoldApple());
//        lstExtendsApple.add(new SilverApple());
//        lstExtendsApple.add(new Fruit());
    }

    static void m5(){
        lstSuperApple = new ArrayList<>();
//        lstSuperApple = new LinkedList<GoldApple>();  //compiler error
//        lstSuperApple  =new Vector<SilverApple>();  //compile error

        lstSuperApple = new Stack<Fruit>();
        lstSuperApple = new ArrayList<Object>();

        lstSuperApple.add(new Apple());
        lstSuperApple.add(new GoldApple());
        lstSuperApple.add(new SilverApple());

//        lstSuperApple.add(new Fruit());  //compiler error
    }
}
