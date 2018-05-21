package oc.p.chapters.c_8_IO.introducingStreams.commonStreamOperations;

import utils.resources.files.Resources;
import java.io.*;

class SkippingOverData {
    File f = Resources.Files.file(this.getClass().getPackage(), "common.txt");

    void m() throws IOException {
        try(FileInputStream fis = new FileInputStream(f)){
            print(fis.read());
            fis.skip(1);
            print(fis.read());
            fis.skip(100);
            print(fis.read());
        }
    }

    void m2() throws IOException {
        try (FileReader fr = new FileReader(f.getPath())){
            print(fr.read());
            fr.skip(1);
            print(fr.read());
            fr.skip(100);
            print(fr.read());
        }
    }

    void print(int i){
        System.out.println((char)i);
    }

    public static void main(String[] args) throws IOException {
        SkippingOverData sod = new SkippingOverData();

        System.out.println(sod.f.exists());
        System.out.println(sod.f.getPath());
        System.out.println(sod.f.getAbsolutePath());

        sod.m();
        System.out.println();
        sod.m2();
    }
}
