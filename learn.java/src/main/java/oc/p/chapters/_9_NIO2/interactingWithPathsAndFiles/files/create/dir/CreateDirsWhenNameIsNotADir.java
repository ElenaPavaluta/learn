package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.create.dir;

import utils.resources.files.Resources;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


class CreateDirsWhenNameIsNotADir {

    public static final String PATH = "path";
    public static final String FILE = "file";
    static String location = Resources.srcMainResourcesPath(new CreateDirsWhenNameIsNotADir());
    static Path path = Paths.get(location, PATH);
    static File file = new File(location + File.separator + FILE);
    static File f = new File(file, "f");
    static Path p = Paths.get(path.toString(), "p");

    static {
        file.mkdirs();
        try {
            path = Files.createDirectories(path);
        } catch (IOException e) {
            System.out.println("err");
        }

        try {
            f.createNewFile();
        } catch (IOException e) {
            System.out.println("err f.createNewFile()");
        }

        try {
            p = Files.createFile(p);
        } catch (IOException e) {
            System.out.println("err Files.createFile(p)");
        }
        System.out.println("f and p created");
    }

    static void m() {
        try {
            System.out.println(f.mkdirs());
            System.out.println("Return false if wanna create dir with already existing name");
        } catch (RuntimeException e) {
            System.out.println("Can't create a dir (using File) if the name is already assigned");
        }

        try {
            Path temp = Paths.get(p.toString(), "p");
            temp = Files.createDirectories(temp);
        } catch (IOException e) {
            System.out.println("Can't create a dir (using path) if the name is already assigned");
        }
    }

    public static void main(String[] args) {
        m();

//        Resources.recursiveDelete(f, file, p, path);
    }
}
