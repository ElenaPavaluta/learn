package oc.p.chapters._8_IO.workingWithStreams.tw._1.conversions;

import utils.resources.files.Resources;

import java.io.*;
import java.util.Arrays;

class C {
    static String path = Resources.srcMainResourcesPath(new C());

    static File dir, f;

    static {
        dir = new File(path);
        f = new File(path + File.separator + "c");
        dir.mkdirs();
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void write() {
        String s = "InputStreamReader \n" +
                "OutputStreamWriter \n" +
                "are the classes which \n" +
                "connect";
        try (Writer w = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(f)))) {
            w.write(s);
        } catch (IOException e) {
        }
    }

    static void read(){
        char[] ca = new char[128];
        try(InputStreamReader isr = new InputStreamReader(new BufferedInputStream(new FileInputStream(f)))){
            isr.read(ca, 10, 100);
            System.out.println(Arrays.toString(ca));
        }catch (IOException e){}
    }

    public static void main(String[] args) {
        write();
        read();

        Resources.clean();
    }
}
