package oc.p.chapters._9_NIO2.comparingLegacyFileAndNIO2Methods;

import utils.resources.files.Resources;
import utils.resources.files.create.populate.CreatePopulate;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

class Compare {
    File file = CreatePopulate.IO.file(this);
    Path path = CreatePopulate.NIO.file(this);

    public static void main(String[] args) {
        Compare comp = new Compare();

//        comp.exits();
//        comp.getName();
//        comp.absolutePath();
//        comp.isDirectory();
//        comp.isFiles();
//        comp.isHidden();
//        comp.length();
//        comp.lastModified();
//        comp.setLastModified();
//        comp.delete();
//        comp.move();
//        comp.createDir();
//        comp.createDirs();
        comp.list();

        Resources.recursiveDelete(comp.file, comp.path);
    }

    void exits() {
        boolean b = file.exists();
        System.out.println(b);

        boolean b2 = Files.exists(path);
        System.out.println(b2);
    }

    void getName() {
        String name = file.getName();
        System.out.println(name);

        Path name2 = path.getFileName();
        System.out.println(path);
        System.out.println(name2);
    }

    void absolutePath() {
        String ap = file.getAbsolutePath();
        System.out.println(ap);

        Path path2 = path.toAbsolutePath();
        System.out.println(path2);
    }

    void isDirectory() {
        boolean b = file.isDirectory();
        System.out.println(b);

        boolean b2 = Files.isDirectory(path);
        System.out.println(b2);
    }

    void isFiles() {
        boolean b = file.isFile();
        System.out.println(b);

        boolean b2 = Files.isRegularFile(path);
        System.out.println(b2);
    }

    void isHidden() {
        boolean b = file.isHidden();
        System.out.println(b);

        try {
            boolean b2 = Files.isHidden(path);
            System.out.println(b2);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    void length() {
        long l = file.length();
        System.out.println(l);

        try {
            long l2 = Files.size(path);
            System.out.println(l2);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    void lastModified() {
        long l = file.lastModified();
        System.out.println(l);

        try {
            FileTime ft = Files.getLastModifiedTime(path);
            System.out.println(ft);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    void setLastModified() {
        long l = Integer.MAX_VALUE;
        file.setLastModified(l);
        System.out.println(LocalDateTime.ofEpochSecond(file.lastModified(), 0, ZoneOffset.UTC));

        FileTime ft = FileTime.from(Instant.now().minus(LocalDateTime.now().getDayOfYear() - 1, ChronoUnit.DAYS));
        try {
            path = Files.setLastModifiedTime(path, ft);
            System.out.println(Files.getLastModifiedTime(path));
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    void delete(){
        boolean b = file.delete();
        System.out.println(b);  //true
        System.out.println(file.exists());  //false

        try {
            Files.delete(path);
        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println(Files.exists(path));  //false

        try {
            System.out.println(Files.deleteIfExists(path));  //false
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    void move(){
        File f =new File(file.getParent(), "newFile");
        boolean b = file.renameTo(f);
        System.out.println(b);

        Path p = Paths.get(path.getParent().toString(), "newPathFile");
        try {
            p = Files.move(path, p);
            System.out.println(p);
        } catch(IOException e) {
            e.printStackTrace();
        }

        Resources.recursiveDelete(f, p);
    }

    void createDir(){
        File f = new File(file.getParent(), "newFDir");
        boolean b = f.mkdir();  //true
        System.out.println(b);
        if(f.exists()){
            System.out.println(f.getName());
            System.out.println(f.delete());  //true
        }

        Path p = Paths.get(path.getParent().toString(), "newPathDir");
        try {
            p = Files.createDirectory(p);
            System.out.println(p.getFileName());
            if(Files.exists(p)){
                Files.delete(p);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    void createDirs(){
        File f = new File(file.getParent(), "\\f\\f2\\f3");
        boolean b = f.mkdirs();
        System.out.println(f);
        System.out.println(b);  //true
        System.out.println(f.exists());  //true

        Path p = Paths.get(path.getParent().toString(),"p", "p2", "p3");
        try {
            p = Files.createDirectories(p);
            System.out.println(p);
        } catch(IOException e) {
            e.printStackTrace();
        }
        Resources.recursiveDelete(f, p);
    }

    void list(){
        File f = new File(Resources.SRC_MAIN_JAVA);
        System.out.println(Arrays.toString(f.listFiles()));

        Path p = Paths.get(Resources.SRC_MAIN_JAVA);
        try {
            Files.list(p).forEach(System.out::println);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
