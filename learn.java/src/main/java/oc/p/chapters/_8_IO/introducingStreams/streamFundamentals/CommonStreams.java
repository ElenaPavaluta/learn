package oc.p.chapters._8_IO.introducingStreams.streamFundamentals;

import java.io.IOException;

class CommonStreams {

    public static void main(String[] args) throws IOException {

        int i = System.in.read();
        System.out.println(i);
        System.err.println(i);
    }
}
