package oc.p.chapters._8_IO.introducingStreams.streamNomenclature.lowLevelVsHighLevel;

import utils.resources.files.Resources;

import java.io.*;

class LowHigh {
    File file;

    {
        file = Resources.pathToFile(this.getClass().getPackage(), "file.txt");
        System.out.println(file.getPath());
    }

    void m(){
        try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))){
            System.out.println(br.readLine());
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    void m2(){
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file.getPath())))){
            System.out.println(ois.readObject());
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LowHigh lh = new LowHigh();

        lh.m();
        System.out.println();
        lh.m2();
    }


}
