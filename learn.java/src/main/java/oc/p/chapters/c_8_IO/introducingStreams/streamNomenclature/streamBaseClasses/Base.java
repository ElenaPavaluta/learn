package oc.p.chapters.c_8_IO.introducingStreams.streamNomenclature.streamBaseClasses;

import java.io.*;

class Base {
    /**
     * java.io library defines four abstract classes
     * that are the parents of all stream classes
     */
    InputStream inputStream;
    OutputStream outputStream;
    Reader reader;
    Writer writer;

    /**
     * Exception to naming convention
     */
    PrintStream printStream;
    PrintWriter printWriter;
}
