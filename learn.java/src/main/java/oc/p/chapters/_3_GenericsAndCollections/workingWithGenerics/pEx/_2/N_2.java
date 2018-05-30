package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.pEx._2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class N_2 {

    {
        List<? super IOException> lst = new ArrayList<Exception> ( );
//        lst.add ( new Exception (  ) );  //compiler error: just doesn't fit
        lst.add ( new IOException ( ) );
        lst.add ( new FileNotFoundException ( ) );  //FileNotFoundException extends IOException
    }

    {
        List<? super IOException> l = new ArrayList<Throwable> (  );

//        l = new ArrayList<FileNotFoundException> (  );  //compiler error
    }

    {
        List<? extends IOException> l;
//        l = new ArrayList<Exception> (  );  //compiler error

        l = new ArrayList<> (  );
        l= new ArrayList<FileNotFoundException> (  );
    }
}
