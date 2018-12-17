package oc.p.chapters._8_IO.workingWithStreams.tw._1.file;

import utils.resources.files.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * fis.read(byte[]) == fis.read(byte[], offset into dest array, max number of bytes to read)
 * fos.wite(byte[]) == fos.write(byte[], offset from where to stard reading from arr, max nb of bytes to write from arr)
 */
class FisFos2 {
    static String path = Resources.srcMainResourcesPackagePath(new FisFos2());

    static File dir = new File(path);
    static File file = new File(path + File.separator + "file");
    static File fileArr = new File(path + File.separator + "fileArr");

    static {
        dir.mkdirs();
        try {
            file.createNewFile();
            fileArr.createNewFile();
        } catch (IOException e) {
        }
        char[] ca = "Line 1\nLine 2\nLine 3".toCharArray();
        try (FileOutputStream fos = new FileOutputStream(file)) {
            for (char c : ca) {
                fos.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void m() {
        byte[] ba = new byte[8];
        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(fileArr)) {
            while ((fis.read(ba)) > 0) {
                System.out.println(Arrays.toString(ba));
                fos.write(ba);
                for (int i = 0; i < ba.length; i++) {
                    ba[i] = 0b00;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void m2() throws IOException {
        Resources.clean();
        fileArr.createNewFile();

        try (FileInputStream fis = new FileInputStream(file); FileOutputStream fos = new FileOutputStream(fileArr)) {
            byte[] ba = new byte[2];
            fis.read(ba, 0, ba.length);
            System.out.println(Arrays.toString(ba));
        }
    }


    public static void main(String[] args) throws IOException {
//        m();
        m2();

        Resources.clean();
    }

}
