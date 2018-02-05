package oc.p.chapters.c_6_ExceptionsAndAssertions.usingTryWithResources;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class TWR {

    static String path = "D:\\workspace\\cip\\learn\\learn.java\\src\\main\\resources\\files\\c6\\tryWithResources\\";
    static String read = path + "read";
    static String write = path + "write";

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

    static void newAp2(){
        try(BufferedReader in  = Files.newBufferedReader(pathRead);
            BufferedWriter out = Files.newBufferedWriter(pathWrite)) {
            out.write(in.readLine());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        oldApproach();
//        newApproach();
        newAp2();
    }
}
