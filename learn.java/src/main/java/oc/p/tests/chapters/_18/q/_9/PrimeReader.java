package oc.p.tests.chapters._18.q._9;

import utils.resources.files.Resources;

import java.io.*;

class PrimeReader {

    static File f = Resources.pathToFile(new PrimeReader(), "f");

    static void write() {
        byte[] arr = new byte[]{2, 3, 5, 7, 11, 13};
        try (FileOutputStream fos = new FileOutputStream(f)) {
            fos.write(arr);
        } catch (IOException e) {

        }
    }

    static void read(){
        try(InputStream is = new FileInputStream(f)){
            System.out.println(is.skip(1));  //1
            System.out.println(is.read());  //3
            System.out.println(is.skip(1));  //1
            System.out.println(is.read());  //7
            System.out.println(is.markSupported());  //false
            is.mark(4);
            System.out.println(is.skip(1));  //1
            is.reset();
            System.out.println(is.read());  //throws IOException

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        write();
        read();
        utils.resources.files.Resources.clean();
    }
}
