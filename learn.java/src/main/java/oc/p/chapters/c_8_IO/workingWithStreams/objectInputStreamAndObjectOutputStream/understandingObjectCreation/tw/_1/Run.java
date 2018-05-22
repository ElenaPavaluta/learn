package oc.p.chapters.c_8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._1;

import utils.resources.files.Resources;
import java.io.*;
import java.util.stream.IntStream;

class Run {
    File file;
    {
        file = Resources.Files.file(this.getClass().getPackage(), "s.txt");
    }

    void write() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
            IntStream.rangeClosed(0,5).forEach(i-> {C c = new C(String.valueOf(i));
                try {
                    oos.writeObject(c);
                } catch(IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    void read() throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){
            while(true){
                C c = (C)ois.readObject();
            }

        }catch(EOFException e){

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Run r = new Run();
        r.write();
        r.read();
        Resources.Files.recursiveDelete(r.file);
    }
}
