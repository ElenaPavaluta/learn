package oc.p.chapters._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation.tw._2;


import utils.print.Print;
import utils.resources.files.Resources;

import java.io.*;

class Serialize {
    static Package pkg = new Serialize().getClass().getPackage();

    static File b = Resources.File.file(pkg, "b");
    static File c = Resources.File.file(pkg, "c");


    static void write() throws IOException {
        try (ObjectOutputStream oosB = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(b)));
             ObjectOutputStream oosC = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(c)))) {

            oosB.writeObject(new B());
            Print.Delimitators.newLine();
            oosC.writeObject(new C());
            Print.Delimitators.equal();
        }
    }

    static void read() throws IOException, ClassNotFoundException {
        try (ObjectInputStream oisB = new ObjectInputStream(new BufferedInputStream(new FileInputStream(b)));
             ObjectInputStream oisC = new ObjectInputStream(new BufferedInputStream(new FileInputStream(c)))) {

            Object o = oisB.readObject();
            Print.Delimitators.newLine();

            o = oisC.readObject();

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        write();
        System.out.println("===== read =====");
        read();

        Resources.clean();
    }

}
