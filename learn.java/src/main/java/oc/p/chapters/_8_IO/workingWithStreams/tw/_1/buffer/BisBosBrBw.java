package oc.p.chapters._8_IO.workingWithStreams.tw._1.buffer;

import utils.resources.files.Resources;

import java.io.*;

class BisBosBrBw {

    static String path = Resources.srcMainResourcesPath(new BisBosBrBw());
    static File dir, f, f2;

    static {
        dir = new File(path);
        f = new File(path + File.separator + "bisBoS");
        f2 = new File(path + File.separator + "bisBoS2");
        dir.mkdirs();
        try {
            f.createNewFile();
            f2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void write() {
        char[] ca = "It seems that\nboth FOS and\nBOS\nhave the same methods".toCharArray();
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f))) {
            for (char c : ca) {
                bos.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void read() {
        byte[] ba = new byte[8];
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f))) {
            while ((bis.read(ba, 0, ba.length)) != -1) {
                for (byte b : ba) {
                    System.out.println((char) b);
                }
            }
        } catch (IOException e) {
        }
    }

    static void brbw() {
        char[] ca = new char[64];
        try (BufferedReader br = new BufferedReader(new FileReader(f));
             BufferedWriter bw = new BufferedWriter(new FileWriter(f2))) {
            String s;
            while ((s = br.readLine()) != null){
                bw.write(s);
                bw.newLine();
                System.out.println(s);
            }

        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        write();
//        read();
        brbw();
        Resources.cleanSrcMainResources();
    }
}
