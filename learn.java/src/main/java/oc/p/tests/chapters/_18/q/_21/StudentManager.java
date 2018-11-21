package oc.p.tests.chapters._18.q._21;

import utils.resources.files.Resources;

import java.io.*;

class StudentManager {

    static File f = Resources.File.file(new StudentManager(), "f");

    static void write() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
            oos.writeObject(new Student("a", 23, 9.7));
            oos.writeObject(new Student("b", 22, 9.6));
            oos.writeObject(new Student("c", 24, 9.5));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            Student record;
            while ((record = (Student) ois.readObject()) != null) {
                System.out.println(record);
            }
        } catch (EOFException e) {
//            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        write();
        read();
        Resources.clean();
    }

}
