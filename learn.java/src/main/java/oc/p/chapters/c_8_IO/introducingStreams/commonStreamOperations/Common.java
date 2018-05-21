package oc.p.chapters.c_8_IO.introducingStreams.commonStreamOperations;

import java.io.*;

class Common {

    InputStream inputStream;
    OutputStream outputStream;
    Reader reader;
    Writer writer;

    void closeStream() throws IOException {
        inputStream.close();
        outputStream.close();
        reader.close();
        writer.close();
    }

    /**
     * When data is written to an output stream/writer, there's
     * no guarantee that the data will make it to the file immediately,
     * so in order to prevent any loses (in case the application terminates
     * unexpectedly), or to minimize the amount this method comes in handy.
     *
     * There's no need to call flush explicitly after finishing
     * writing to a file, since close() will do this automatically
     */
    void flushingTheResource() throws IOException {
        outputStream.flush();
        writer.flush();
    }



}
