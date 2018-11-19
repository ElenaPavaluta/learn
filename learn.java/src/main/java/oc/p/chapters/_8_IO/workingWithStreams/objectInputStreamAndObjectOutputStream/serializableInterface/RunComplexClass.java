package oc.p.chapters._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.serializableInterface;

import utils.resources.files.Resources;
import java.io.*;
import java.util.stream.IntStream;

class RunComplexClass {
    File file;
    {
        file = Resources.File.file(this.getClass().getPackage(), "cc.csv");
    }

    void write() throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            int i = 0;
            ComplexClass cc = new ComplexClass(i++, null, null);
            ComplexClass.MemberClass ccmc =cc.new MemberClass("user", "password");
            ComplexClass.StaticClass ccsc = new ComplexClass.StaticClass("user", "password");

            IntStream.rangeClosed(0, 5).forEach(j->{
                ComplexClass c = new ComplexClass(j, ccmc, ccsc);
                try {
                    oos.writeObject(c);
                } catch(IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    void read() throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            while(true){
               Object o = ois.readObject();
               if(o instanceof ComplexClass){
                   ComplexClass cc = (ComplexClass)o;
                   System.out.println(cc);
               }
            }
        }catch(EOFException e){
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        RunComplexClass run = new RunComplexClass();
        run.write();
        run.read();

        Resources.cleanSrcMainResources();
    }
}
