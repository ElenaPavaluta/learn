package oc.p.tests.chapters._18.q._14;

import utils.resources.files.Resources;

import java.io.*;

class Serialize {

    static File f = Resources.pathToFile(new Serialize(), "f");

    static void write() throws IOException {
        Cereal c = new Cereal();
        c.setName("bla bla");
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)))){
            oos.writeObject(c);
        }
    }

    static void read() throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)))){
            Object o = ois.readObject();
            if(o instanceof Cereal){
                Cereal c = (Cereal)o;
                System.out.println(c.getName());
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        write();
        read();
        utils.resources.files.Resources.clean();
    }
}
