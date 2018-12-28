package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.readAndWrite.newBuffered.tw.rmb.objectStream;

import utils.javaClass.implemets.serializable.simple.Tea;
import utils.javaClass.implemets.serializable.simple.TeaPot;
import utils.resources.files.Resources;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class OS {

    static Package pkg = new OS().getClass().getPackage();
    static List<TeaPot> lst = Arrays.stream(Tea.values()).map(TeaPot::new).collect(Collectors.toList());
    static File f = Resources.pathToFile(pkg, "f2");
    static {
        try(ObjectOutputStream ous = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)))){
            lst.forEach(o -> {
                try {
                    ous.writeObject(o);
                } catch(IOException e) {
                    e.printStackTrace();
                }
            });
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static void read(){
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)))){
            Object o = null;
            while(true){
                o = ois.readObject();
                System.out.println(o);
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(EOFException e){

        } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        read();
        utils.resources.files.Resources.clean();
    }
}
