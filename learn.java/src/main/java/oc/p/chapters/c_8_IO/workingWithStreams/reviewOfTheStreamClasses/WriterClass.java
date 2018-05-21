package oc.p.chapters.c_8_IO.workingWithStreams.reviewOfTheStreamClasses;

import java.io.*;

class WriterClass {

    Writer writer;  //abstract class

    /**
     * Takes an OutputStream as param an return a Writer
     */
    OutputStreamWriter outputStreamWriter;

    FileWriter fileWriter;  //extends OutoutStreamWriter

    BufferedWriter bufferedWriter;

    PrintWriter printWriter;

    {
        OutputStream outputStream = null;
        outputStreamWriter = new OutputStreamWriter(outputStream);

        writer = new OutputStreamWriter(outputStream);
    }
}
