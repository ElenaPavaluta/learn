package oc.p.chapters.c2_PatternsAndPrinciples.workingWithDesignPatterns.creatingImmutableObjects.pEx.nOk;

import java.util.ArrayList;
import java.util.List;


class Child extends Base {
    private List<String> lst;

    protected Child(int b, List<String> lst) {
        super ( b, lst );
        this.lst = lst;
    }

    public static void main(String[] args) {
        List<String> lst = new ArrayList<> ( );
        lst.add ( "1" );
        Base b = new Base ( 13, lst );
        System.out.println ( "b.getLst() = " + b.getLst ( ) ); // [1]
        Base bc = new Child ( 13, lst );
        lst.add ( "2" );
        System.out.println ( "bc.getLst() = " + bc.getLst ( ) ); //[1 2] : due to polymorphism
        Child c = (Child) bc;
        System.out.println ( "c.getLst() = " + c.getLst ( ) );  // [1 2]
    }

    /**
     * This method overrides the base method, allowing in this manner to hide the base variable (which is intended not be
     * modified)
     */
    @Override
    protected List<String> getLst() {
        return lst;
    }
}
