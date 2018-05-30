package oc.p.chapters._8_IO.workingWithStreams.reviewOfTheStreamClasses;

import java.io.*;

class OutputStreamClass {

    OutputStream outputStream;

    FileOutputStream fileOutputStream;  //low level

    FilterOutputStream filterOutputStream;  //extends OutputStream; not on OCP

    BufferedOutputStream bufferedOutputStream;  //extends FilterOutputStream

    /**
     * System.out
     *
     * System.err;
     */
    PrintStream printStream;  //extends OutputStream

    ObjectOutputStream objectOutputStream;


    {
        outputStream = System.out;
        outputStream = System.err;

        printStream = System.out;
        printStream = System.err;
    }

}
