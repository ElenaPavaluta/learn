package oc.p.chapters._8_IO.introducingStreams.commonStreamOperations.markingTheStream;

import java.io.IOException;
import java.io.InputStream;

class InputStream_ {

    InputStream is;

    {
        boolean b = is.markSupported();

        is.mark(5);

        try {
            is.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            is.skip(5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
