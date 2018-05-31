package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources;

import utils.resources.files.Resources;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class TWR {

    static final String READ = "read.txt";
    static final String WRITE = "write.txt";
    static String read, write;

    static{
        TWR twr = new TWR();
        Package pkg = twr.getClass().getPackage();
        java.io.File d = Resources.IO.File.directory(pkg);
        System.out.println(d.getPath());
        System.out.println(d.getAbsolutePath());
        java.io.File r = Resources.IO.File.file(pkg, READ);
        System.out.println(r.getPath());
        System.out.println(r.getAbsolutePath());
        read  = r.getPath();
        write = Resources.IO.File.file(pkg, WRITE).getPath();
    }

    static Path pathRead = Paths.get(read);
    static Path pathWrite = Paths.get(write);

    static void oldApproach() throws IOException {
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = Files.newBufferedReader(pathRead);
            out = Files.newBufferedWriter(pathWrite);
            out.write(in.readLine());
        } finally {
            try {
                in.close();
            } catch(IOException e) {
            }
            try {
                out.close();
            } catch(IOException e) {
            }
        }
    }

    static void newApproach() throws IOException {
        try(BufferedReader in = Files.newBufferedReader(pathRead);
            BufferedWriter out = Files.newBufferedWriter(pathWrite)) {
            out.write(in.readLine());
        }
    }

    static void newAp2() {
        try(BufferedReader in = Files.newBufferedReader(pathRead);
            BufferedWriter out = Files.newBufferedWriter(pathWrite)) {
            out.write(in.readLine());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        oldApproach();
        newApproach();
//        newAp2();
    }
}
