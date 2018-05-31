package oc.p.chapters._8_IO.workingWithStreams.reviewOfTheStreamClasses.otherStreamClasses;

import utils.resources.files.Resources;
import java.io.*;

class StreamToChar {

    File f = Resources.IO.File.file(this.getClass().getPackage(), "f");

    public static void main(String[] args) throws IOException {
        StreamToChar streamToChar = new StreamToChar();
        streamToChar.write();
        streamToChar.read();
        Resources.IO.File.recursiveDelete(streamToChar.f);
    }

    void write() throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)))) {
            bw.write("line \nline 2\n line 3");
        }
    }

    void read() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)))) {
            String s;
            while((s= br.readLine())!=null){
                System.out.println(s);
            }
        } catch(EOFException e) {

        }

    }
}
