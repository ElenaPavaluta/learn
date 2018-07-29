package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources;

import utils.resources.files.Resources;
import utils.resources.files.create.populate.CreatePopulate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class TWR {

    static Path read;
    static Path write;

    static {
        Package pkg = new TWR().getClass().getPackage();
        read = CreatePopulate.NIO.File.Path.file(pkg, "read");
        write = Resources.NIO.File.Path.file(pkg, "write");
    }

    static void oldApproach() throws IOException {
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = Files.newBufferedReader(read);
            out = Files.newBufferedWriter(write);
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
        try(BufferedReader in = Files.newBufferedReader(read);
            BufferedWriter out = Files.newBufferedWriter(write)) {
            out.write(in.readLine());
        }
    }

    static void newAp2() {
        try(BufferedReader in = Files.newBufferedReader(read);
            BufferedWriter out = Files.newBufferedWriter(write)) {
            out.write(in.readLine());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        oldApproach();
//        newApproach();
//        newAp2();
        Resources.recursiveDelete(read, write);
    }
}
