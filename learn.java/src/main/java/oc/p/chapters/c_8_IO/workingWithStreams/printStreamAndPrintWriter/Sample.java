package oc.p.chapters.c_8_IO.workingWithStreams.printStreamAndPrintWriter;

import utils.resources.files.Resources;
import java.io.*;

class Sample {

    public static void main(String[] args) throws IOException {
        File f = Resources.Files.file(new Sample().getClass().getPackage(), "c");

        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)))){
            pw.print("Today wether is: ");
            pw.println("sunny");
            pw.print("Today's temperature at the zoo is: ");
            pw.print(1/3.0);
            pw.println("'C'");
            pw.format("It has rained 10.12 inches this year");
            pw.println();
            pw.printf("It may rain 21.2 more inches this year");
        }

        Resources.Files.recursiveDelete(f);
    }
}
