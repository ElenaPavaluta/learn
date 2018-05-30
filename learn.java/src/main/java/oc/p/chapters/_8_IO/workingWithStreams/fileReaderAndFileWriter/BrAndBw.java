package oc.p.chapters._8_IO.workingWithStreams.fileReaderAndFileWriter;

import utils.resources.files.Resources;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class BrAndBw {
    File f, f2;

    {
        Package p = this.getClass().getPackage();
        f = Resources.Files.file(p, "f.txt");
        f2 = Resources.Files.file(p, "f2.txt");

        fill(f);
    }

    public static void main(String[] args) throws IOException {
        BrAndBw bb = new BrAndBw();

        bb.m2(bb.m());

        Resources.Files.recursiveDelete(bb.f, bb.f2);
    }

    private void fill(File f) {
        String s = "First line \n Second line \n  Third line \n Fourth line \n Fifth line";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
            writer.write(s);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    List<String> m() throws IOException {
        List<String> lst = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(new FileReader(f))){
            String s;
            while((s = r.readLine()) != null){
                lst.add(s);
            }
        }
        return lst;
    }

    void m2(List<String> lst) throws IOException {
        try (BufferedWriter w  =new BufferedWriter(new FileWriter(f2))){
            lst.forEach(s -> {
                try {
                    System.out.println(s);
                    w.write(s);
                    w.newLine();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
