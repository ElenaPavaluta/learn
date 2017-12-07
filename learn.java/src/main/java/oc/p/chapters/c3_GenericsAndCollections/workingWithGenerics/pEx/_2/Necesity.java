package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.pEx._2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Necesity {
    String s = "addedString";

    List<String> ls = new ArrayList<> ( );
    List<Object> lo = new ArrayList<> ( );

    {
        ls.add ( "ls" );
        lo.add ( "lo" );
        lo.add ( new Object ( ) );
        lo.add ( new StringBuilder ( ) );
    }

    {
//        addString (ls);  //compiler error: although String is a subclass of Object. List<String> is not subclass of List<Object>
        addString ( lo );

        addStringUnboundedWildcard ( ls );
        addStringUnboundedWildcard ( lo );

        addStringUpperBoundWildcard ( ls );
//        addStringUpperBoundWildcard ( lo );  compiler error: Object doesn't extend String

        addStringLowerBoudWildcard ( ls );
        addStringLowerBoudWildcard ( lo );
    }

    void addString(List<Object> l) {
        l.add ( s );
        l.add ( LocalDateTime.now ( ) );
    }

    void addStringUnboundedWildcard(List<?> l) {
//        l.add ( s );  //compiler error: one can add an object of another type
        /**
         * the list of <?> (unbounded wildcard) and <? extend type>
         *     (upper bound wildcard) become immutable for the adding operations; remove still works
         */
        l.remove ( 0 );
    }

    void addStringUpperBoundWildcard(List<? extends String> l) {  //? is a class which extends String (or String) )
//        l.add ( s );  //compiler error: one can add an object of another type
    }

    void addStringLowerBoudWildcard(List<? super String> l) {  //? is a super class for String(or String)
        ls.add ( s );
    }
}
