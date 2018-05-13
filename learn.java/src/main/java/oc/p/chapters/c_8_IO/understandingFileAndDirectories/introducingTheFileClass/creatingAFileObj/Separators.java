package oc.p.chapters.c_8_IO.understandingFileAndDirectories.introducingTheFileClass.creatingAFileObj;


import java.io.File;

class Separators {

    static void separators(){
        System.out.println(System.getProperty("file.separator"));
        System.out.println(File.separator);
    }

    public static void main(String[] args) {
        separators();
    }
}
