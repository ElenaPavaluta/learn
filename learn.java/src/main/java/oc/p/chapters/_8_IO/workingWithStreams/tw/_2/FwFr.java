package oc.p.chapters._8_IO.workingWithStreams.tw._2;

import sun.nio.ch.FileKey;
import utils.resources.files.Resources;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.IntStream;

class FwFr {

    File file = Resources.pathToFile(this).toFile();

    void write(){
        try(FileWriter fw = new FileWriter(file)){
            IntStream.rangeClosed(Integer.MAX_VALUE-11, Integer.MAX_VALUE-1)
                    .forEach(i-> {
                        try {
                            fw.write(i);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    void read(){
        try(FileReader fr = new FileReader(file)){
            int i;
            while((i=fr.read())!=-1){
                System.out.println(i);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FwFr o = new FwFr();

        o.write();
        o.read();

        System.out.println(Integer.MAX_VALUE);
        System.out.println((int)Character.MAX_VALUE);
//        Resources.clean();
    }
}
