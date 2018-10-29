package oc.p.tests.chapters._18.q._27;

import utils.resources.files.Resources;

import java.io.*;

class Furniture {

    static File f = Resources.File.file(new Furniture(), "f");

    static void m() throws IOException {
        Writer w = new FileWriter(f);
        try (BufferedWriter bw = new BufferedWriter(w)) {
            bw.write("Blue coach on sale");
            /**
             * When the finally block is reached, also the w Writer is
             * flushed and closed
             */
        } finally {
            System.out.println(w == null);
            w.flush();
            w.close();
        }
        System.out.println("done");
    }

    public static void main(String[] args) {
        try {
            m();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Resources.recursiveDelete(f);
        }

    }
}


