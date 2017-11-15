package oc.p.chapters.c2_PatternsAndPrinciples.workingWithDesignPatterns.creatingImmutableObjects.pEx.ok.finalMethods;

import java.util.ArrayList;
import java.util.List;

class Child extends Base{

    public Child(int i, List<String> lst) {
        super ( i, lst );
    }

    public static void main(String[] args) {
        List<String> lst = new ArrayList<> (  );
        lst.add ( "1" );
        
        Base b = new Child ( 13, lst );
        System.out.println ( "b.getLst () = " + b.getLst () );  //[1]

        Child bc = (Child)b;
        System.out.println ( "bc.getLst () = " + bc.getLst () );  //[1]

        lst.add ( "2" );
        Child c = new Child ( 13, lst );
        System.out.println ( "c.getLst () = " + c.getLst () );  //[1 2]
    }
}
