package oc.p.chapters._8_IO.workingWithStreams.printStreamAndPrintWriter;

import utils.resources.files.Resources;
import java.io.*;
import java.util.Locale;

/**
 * Can be created using also an OutputStream
 */
class PrintWriterClass {
    File f = Resources.File.file(this.getClass().getPackage(), "b");

    {
        try(PrintWriter pw = new PrintWriter(f.getPath());
            PrintWriter pw2 = new PrintWriter(f);
            PrintWriter pw3 = new PrintWriter(new BufferedWriter(new FileWriter(f)));
            /*
            Can be created using also an OutputStream
             */
            PrintWriter pw4 = new PrintWriter(new FileOutputStream(f))) {

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriterClass pwc = new PrintWriterClass();

        pwc.write();
        pwc.print();

        Resources.cleanSrcMainResources();
    }

    void write() throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(f)) {
            pw.write("line 1\nline 2\nline 3\nline 4");
        }
    }

    void print() throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(f)) {
            pw.print("New String\n\n");
            pw.println();
            pw.println("print ln");
            pw.print("new line");
            pw.println();
            pw.printf("%s are mere", "Ana");
            pw.println();
            pw.printf(Locale.US, "Money: %f", 1234.5);
            pw.println();
            pw.format("%s are mere", "Ana");
            pw.println();
            pw.format(Locale.US, "Money: %f", 1234.5);
        }
    }
}
