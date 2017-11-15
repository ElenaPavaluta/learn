package oc.p.chapters.c2_PatternsAndPrinciples.workingWithDesignPatterns.creatingImmutableObjects.pEx.ok.finalMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Base {

    private final int i;
    final private List<String> lst;

    Base(int i, List<String> lst) {
        this.i = i;
        if (lst == null) {
//            this.lst = new ArrayList<> ( );  //with the throw statement this is a valid statement,
// because it will never reach the last line (the assignment line)
            throw new RuntimeException ( "Null input");
        }
        this.lst = new ArrayList<> ( lst );
    }

    public final int getI() {
        return i;
    }

    public final List<String> getLst() {
        return Collections.unmodifiableList ( lst );
    }

    public static void main(String[] args) {
        Base b = new Base ( 12, null );
        System.out.println ( "b.lst = " + b.lst );
    }
}
