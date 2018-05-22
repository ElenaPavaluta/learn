package oc.p.chapters.c_8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._2;


import utils.resources.files.Resources;
import java.io.*;

import static java.lang.System.in;

class Serialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        C c = new C();
        File f = Resources.Files.file(c.getClass().getPackage(), "c");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))){
            oos.writeObject(c);
        }
        System.out.println();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
            c = (C)ois.readObject();
        }

        Resources.Files.recursiveDelete(f);
    }
}
