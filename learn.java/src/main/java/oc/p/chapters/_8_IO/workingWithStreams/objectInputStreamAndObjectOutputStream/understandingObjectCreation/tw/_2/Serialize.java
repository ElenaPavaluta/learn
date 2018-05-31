package oc.p.chapters._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._2;


import utils.resources.files.Resources;
import java.io.*;

class Serialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        C c = new C();
        File f = Resources.IO.File.file(c.getClass().getPackage(), "c");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))){
            oos.writeObject(c);
        }
        System.out.println();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
            c = (C)ois.readObject();
        }

        Resources.IO.File.recursiveDelete(f);
    }
}
