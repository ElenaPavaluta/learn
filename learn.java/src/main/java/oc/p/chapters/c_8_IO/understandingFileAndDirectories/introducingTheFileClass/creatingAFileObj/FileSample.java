package oc.p.chapters.c_8_IO.understandingFileAndDirectories.introducingTheFileClass.creatingAFileObj;

import utils.resources.files.Resources;
import java.io.File;
import java.io.IOException;

class FileSample {
     void m() throws IOException {
        String pkg = this.getClass().getPackage().getName();

        String path = Resources.Files.pathWithSeparator(pkg);
         System.out.println(path);

         File file = new File(path + "zoo.txt");
         System.out.println(file.exists());
         System.out.println(file);
         file.mkdirs();
         file.createNewFile();
         System.out.println(file.exists());
         System.out.println(file.isDirectory());
         System.out.println(file.isFile());
    }

    void m2() throws IOException {
     File f = new File("zoo.txt");
//     f.mkdirs();
     f.createNewFile();
        System.out.println(f.exists());
     }


    void mChar(){
        char c = '\uaaaa';
        System.out.println(c);
    }

    public static void main(String[] args) throws IOException {
      FileSample fs = new FileSample();
//      fs.m();
        fs.m2();
        Resources.Files.delAll();
    }
}
