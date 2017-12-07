package oc.p.chapters.c3_GenericsAndCollections.workingWithGenerics.pEx._2;

import sun.misc.REException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class N_3 {

    List<Object> lo;
    List<?> lu;
    List<? extends Exception> lub;
    List<? super Exception> llb;

    {
        lo = new ArrayList<> ( );
//        lo = new ArrayList<Exception> (  );  //compiler error
        lo.add ( new Exception ( ) );
        lo.add ( new StringBuilder ( ) );
    }

    {
//        lu.add ( new StringBuilder (  ) );  //both lu and lub become immutable for the add operation:the compiler can't know the actual type
        lu = new ArrayList<> ( );
        lu = new ArrayList<Object> ( );
        lu = new ArrayList<Throwable> ( );
        lu = new ArrayList<FileNotFoundException> ( );  //anything can be assigned to this lu, but the add operation rises a compilation error
    }

    {
        lub = new ArrayList<> ( );
//        lub = new ArrayList<Throwable> (  );  //compiler error: the Exception is the upper bound.
        lub = new ArrayList<RuntimeException> ( );
        lub = new ArrayList<IOException> ( );
//        lub.add ( new IOException (  ) );  //not allowed: the actual type isn't known
    }

    {
        llb = new ArrayList<Object> ( );
        llb = new ArrayList<Throwable> ( );
        llb = new ArrayList<> (  );
//        llb = new ArrayList<RuntimeException> (  );  //The Exception is the lower bound
        llb.add ( new Exception (  ) );
//        llb.add ( new Throwable (  ) );  //compiler error:
        llb.add ( new RuntimeException () );
    }
}
