package oc.p.chapters._8_IO.workingWithStreams.fileInputStreamAndFileOutputStream;

import utils.resources.files.Resources;

import java.io.*;

/**
 * It is recommended that the buffer size is a power
 * of 2
 * <p>
 * Only BufferedInputStream and BufferedReader return true for markSupported
 */
class BisAndBos {

    File file, copy;

    {
        file = Resources.File.file(this.getClass().getPackage(), "info.jpg");
    }

    public static void main(String[] args) throws IOException {
        BisAndBos bb = new BisAndBos();

        bb.m();

        Resources.clean();
    }

    void m() throws IOException {
        copy = Resources.File.file(this.getClass().getPackage(), "copy.jpg");
        try (InputStream in = new BufferedInputStream(new FileInputStream(file));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(copy))) {
            byte[] buff = new byte[16];
            int lengthRead;
            /**
             * Reads some number of bytes from the
             * input stream and stores them into
             * the buffer array.
             * The number of bytes actually read is
             * returned as an integer
             */
            while ((lengthRead = in.read(buff)) > 0) {
                /**
                 *  Writes len bytes from the specified
                 *  byte array
                 *  starting at offset off to this output stream.
                 */
                out.write(buff, 0, lengthRead);
                /**
                 * Same as write(buff, 0, buff.length);
                 */
                out.write(buff);
                out.flush();
            }
        }
    }
}
