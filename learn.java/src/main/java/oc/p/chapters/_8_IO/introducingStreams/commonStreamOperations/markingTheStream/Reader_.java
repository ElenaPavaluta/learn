package oc.p.chapters._8_IO.introducingStreams.commonStreamOperations.markingTheStream;

import java.io.IOException;
import java.io.Reader;

class Reader_ {

    Reader reader;
    {
        boolean b = reader.markSupported();

        try {
            reader.mark(10);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            reader.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            reader.skip(5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
