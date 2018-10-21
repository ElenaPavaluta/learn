package oc.p.chapters._8_IO.workingWithStreams.tw._1.file;

import utils.resources.files.Resources;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

class FrFw {
    static String path = Resources.srcMainResourcesPath(new FrFw());
    static File dir, f, f2;

    static {
        dir = new File(path);
        f = new File(path + File.separator + "frfw");
        f2 = new File(path + File.separator + "frfw2");
        dir.mkdirs();
        try {
            f.createNewFile();
            f2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void m() {
        try(FileWriter fw = new FileWriter(f)){
            fw.write("Line 1\nLine 2\nLine 3");
        }catch (IOException e){
        }
    }

    static void m2(){
        try(FileReader fr = new FileReader(f)){
            int i;
            while ((i =fr.read()) != -1){
                System.out.println((char) i);
            }
        }catch (IOException e){
        }
    }

    static void m3(){
        char[] ca = new char[2];
        try(FileReader fr = new FileReader(f)){
            while(fr.read(ca) != -1){
                System.out.println(Arrays.toString(ca));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    static void m4(){
        char[] ca = "Mirage \nArmin van Buuren\nNice track".toCharArray();
        try(FileWriter fw  =new FileWriter(f2)){
            fw.write(ca, 0, ca.length);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    static void m5(){
        char[] ca = new char[1024];
        try(FileReader fr = new FileReader(f2)){
            while((fr.read(ca, 0, ca.length)) !=-1){
                System.out.println(Arrays.toString(ca));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        m();
//        m2();
//        m3();
        m4();
        m5();

        Resources.recursiveDelete(f, f2, dir);
    }
}
