package oc.p.chapters._8_IO.understandingFileAndDirectories.introducingTheFileClass.workingWithAFileObject.tw;

import utils.resources.files.Resources;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Only create new File throws an exception: IOException
 */
class Ms {

    static String path = Resources.srcMainResourcesPath(new Ms().getClass().getPackage());
    static File dir;
    static File file;
    static File ne = new File("nonExistent");
    static File dest = new File(path + File.separator + "a" + File.separator + "b");
    static List <File> lst /*= Arrays.asList(dir, file, ne)*/;  //NPE:

    /**
     * List, is eagerly evaluated
     * stream is lazy evaluated
     */

    static {
        dir = new File(path + File.separator + "dir");
        dir.mkdirs();

        file = new File(dir, "file.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        lst = Arrays.asList(dir, file, ne);
    }

    static void m(Consumer <File> consumer) {
        lst.forEach(consumer);
    }


    static void m() {
//        m(f-> System.out.println(f.exists()));
//        m(f-> System.out.println(f.getName()));
//        m(f-> System.out.println(f.getAbsolutePath()));
//        m(f-> System.out.println(f.isDirectory()));
//        m(f-> System.out.println(f.isFile()));
//        m(f-> System.out.println(f.length()));
//        m(f -> System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(f.lastModified()), ZoneId.systemDefault())));
//        m(f-> System.out.println(f.getParent()));
//        m(f-> System.out.println(f.getParentFile()));
//        m(f-> System.out.println(Arrays.toString(f.listFiles())));
//        m(f-> System.out.println(f.delete()));
        m(f-> System.out.println(f.renameTo(dest)));
    }

    public static void main(String[] args) {
        m();


        Resources.recursiveDelete(file, dir);
    }
}
