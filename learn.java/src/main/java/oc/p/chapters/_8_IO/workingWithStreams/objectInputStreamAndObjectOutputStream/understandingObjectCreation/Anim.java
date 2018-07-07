package oc.p.chapters._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.understandingObjectCreation;

import utils.resources.files.Resources;
import java.io.*;

class Anim implements Serializable {

    private static char type = 'C';
    private transient String name;
    private transient int age = 10;

    {
        this.age = 14;
    }

    Anim() {
        this.name = "Unknown";
        this.age = 12;
        this.type = 'Q';
    }

    Anim(String name, int age, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Anim a = new Anim("Lenovo", 4, 'L');

        File f = Resources.IO.File.file(a.getClass().getPackage(), "a");

        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)))) {
            oos.writeObject(a);
        }

        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)))) {
            a = (Anim)ois.readObject();
            System.out.println(a);
        } catch(EOFException e) {
        }

        Resources.IO.File.recursiveDelete(f);

    }

    @Override
    public String toString() {
        return "Anim{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dbType=" + type +
                '}';
    }
}
