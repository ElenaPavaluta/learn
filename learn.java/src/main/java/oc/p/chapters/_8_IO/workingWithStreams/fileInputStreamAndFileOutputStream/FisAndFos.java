package oc.p.chapters._8_IO.workingWithStreams.fileInputStreamAndFileOutputStream;

import utils.resources.files.Resources;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * The data in a FileInputStream object is commonly accessed by
 * successive calls to the read() method until a value of -1 is returned,
 * indicating that the end of the stream—in this case the end
 * of the file—has been reached
 *
 */
class FisAndFos {
    File r = Resources.IO.File.file(this.getClass().getPackage(), "r.txt");
    File w = Resources.IO.File.file(this.getClass().getPackage(), "w.txt");
    File copy;

    public static void main(String[] args) throws IOException {
        FisAndFos ff = new FisAndFos();

        ff.m();
        ff.m2();

        clean(ff);
    }

    public static void clean(FisAndFos ff) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Resources.IO.File.recursiveDelete(ff.w, ff.copy);
                System.exit(0);
            }
        }, 5);
    }

    void m() throws IOException {
        try(InputStream is = new FileInputStream(r.getPath());
            OutputStream os = new FileOutputStream(w)) {
            int b;
            while((b = is.read()) != -1) {
                os.write(b);
            }
        }
    }

    void m2() throws IOException {
        File f = Resources.IO.File.file(this.getClass().getPackage(), "fos.jpg");
        copy = Resources.IO.File.file(this.getClass().getPackage(), "fosCopy.jpg");

        try(FileInputStream fis = new FileInputStream(f);
        FileOutputStream fos = new FileOutputStream(copy)){
            int b;
            while((b = fis.read()) != -1){
                fos.write(b);
            }
        }
    }
}

