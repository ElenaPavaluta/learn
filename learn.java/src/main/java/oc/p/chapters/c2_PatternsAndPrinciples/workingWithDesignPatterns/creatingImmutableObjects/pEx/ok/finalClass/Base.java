package oc.p.chapters.c2_PatternsAndPrinciples.workingWithDesignPatterns.creatingImmutableObjects.pEx.ok.finalClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class Base {
    private final int i;
    final private List<String> lst;

    Base(int i, List<String> lst) {
        this.i = i;
        if (lst == null) {
            this.lst = new ArrayList<> ( );
        } else {
            this.lst = new ArrayList<> ( lst );
        }
    }

    static void m() {
//        class C extends Base{  //compiler error; it's final, can't be extended
//
//        }

        class Aa extends A {  //local inner class
            //this can access only final variables or effective final ones (assigned a value only once)
        }

        I i = new I ( ) {  //anonymous  inner class

        };
    }

    public static void main(String[] args) {

    }

    public int getI() {
        return i;
    }

    public List<String> getLst() {
        return Collections.unmodifiableList ( lst );
    }

    interface I {
    }

    //member inner class
    class A {
    }
}
