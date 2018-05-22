package oc.p.chapters.c_8_IO.workingWithStreams.fileReaderAndFileWriter;

import utils.resources.files.Resources;
import java.io.*;

class FrAndFw {
    File f, f2;

    {
        Package p = this.getClass().getPackage();
        f = Resources.Files.file(p, "f.txt");
        f2 = Resources.Files.file(p, "f2.txt");

        fill(f);
    }

    private void fill(File f) {
        String s = "This is first line; \n This is the second line";
        try(Writer w = new FileWriter(f)) {
            char[] ca = s.toCharArray();
            int i = 0;
            while(i < ca.length) {
                w.write(ca[i]);
                i++;
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    void m() throws IOException {
        try (Reader r = new FileReader(f);
        Writer w = new FileWriter(f2)){
            int b;
            while((b = r.read())!=-1){
                w.write(b);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        FrAndFw ff = new FrAndFw();

        ff.m();

        Resources.Files.recursiveDelete(ff.f, ff.f2);
    }
}
