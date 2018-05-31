package oc.p.chapters._8_IO.introducingStreams.commonStreamOperations;

import utils.resources.files.Resources;
import java.io.*;
import java.util.stream.IntStream;

/**
 * InputStream and Reader classes include
 * mark(int) and reset()
 * methods to move the stream back to an earlier position.
 * Before calling either of these methods, you should call the
 * markSupported(),
 * which returns true only if mark() is supported.
 */
class MarkingTheStream {

    File file = Resources.IO.File.file(this.getClass().getPackage(), "common.txt");

    public static void main(String[] args) throws IOException {
        MarkingTheStream mts = new MarkingTheStream();

//        mts.m();  //seems that FileInputStream does not support marking
//        mts.m2();
//        mts.m3();
//        mts.m4();

        //reader
//        mts.m5();
//        mts.m6();
        mts.m7();
    }

    void m() throws IOException {
        try(FileInputStream fis = new FileInputStream(file.getPath())) {
            System.out.println((char) fis.read());
            if(fis.markSupported()) {
                fis.mark(100);
                System.out.println((char) fis.read());
                System.out.println((char) fis.read());
                fis.reset();
            }
            System.out.println();
            int i;
            while((i = fis.read()) != -1) {
                System.out.println((char) i);
            }
        }
    }

    void m2() throws IOException {
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file.getPath()))) {
            System.out.println((char) bis.read());
            if(bis.markSupported()) {
                bis.mark(100);
                System.out.println((char) bis.read());
                System.out.println(bis.read());
                bis.reset();
            }
            System.out.println();
            int i;
            while((i = bis.read()) != -1) {
                System.out.println((char) bis.read());
            }

        }
    }

    void m3() throws IOException {
        try(FileInputStream fis = new FileInputStream(file)){
            int i;
            while((i = fis.read()) != -1){
                System.out.println((char)i);
            }
            System.out.println((char)fis.read());
        }
    }

    void m4() throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){
            int i;
            while((i = bis.read())!=-1){
                System.out.println((char)i);
            }
            if(bis.markSupported()){
                bis.mark(100);
                System.out.println((char)bis.read());
                bis.reset();
            }
        }
    }

    void m5() throws IOException {
        try (FileReader fr = new FileReader(file.getPath())){
            int i;
            while((i=fr.read()) !=-1){
                System.out.println((char)i);
            }
        }
    }

    void m6() throws IOException {
        try(FileReader fr = new FileReader(file)){
            System.out.println((char)fr.read());
            if(fr.markSupported()){
                fr.mark(100);
                IntStream.range(0, 2).forEach(i -> {
                    try {
                        System.out.println((char) fr.read());
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                });
                fr.reset();
            }
            IntStream.range(0, 3).forEach(i -> {
                try {
                    System.out.println((char) fr.read());
                } catch(IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    void m7() throws IOException {
     try(BufferedReader br = new BufferedReader(new FileReader(file))){
         System.out.println((char)br.read());
         if(br.markSupported()){
             br.mark(100);
             System.out.println("\n" + (char)br.read() + "\n");
             br.reset();
         }
         System.out.println((char)br.read());
     }
    }
}
