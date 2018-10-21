package oc.p.chapters._8_IO.workingWithStreams.tw._1.file;

import utils.resources.files.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class FisFos {
    static String path = Resources.srcMainResourcesPath(new FisFos());

    static File dir,  write;

    static {
        dir = new File(path);
        dir.mkdirs();
        write = new File(path + File.separator + "write");
    }

    static void write() throws IOException {
        write.createNewFile();

        try (FileOutputStream fos = new FileOutputStream(write);){
            String s = "Now I'm going to write \nin a file";
            char[]  ca = s.toCharArray();
            for(int i =0; i<ca.length; i++){
                fos.write(ca[i]);
            }
        }
    }

    static void read(){
        try(FileInputStream fis =new FileInputStream(write)){
            String s2 = "";
            int i;
            while ((i=fis.read())!=-1){
                s2+=(char)i;
            }
            System.out.println(s2);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(path);
        write();
        read();

        Resources.recursiveDelete(write, dir);
    }
}
