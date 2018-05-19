package utils.resources.files;

import java.io.File;
import java.io.IOException;
import java.util.function.Predicate;

public interface Resources {
    String RESOURCES = "resources";
    String JAVA = "java";
    String SRC_MAIN = "src" + File.separator + "main";
    String SRC_MAIN_RESOURCES = SRC_MAIN + File.separator + RESOURCES;
    String SRC_MAIN_JAVA = SRC_MAIN + File.separator + JAVA;

    Predicate<File> NOT_NULL = file -> file != null;
    Predicate<File> HAS_NO_CHILDS = file -> file.listFiles().length == 0;


    static String path(String path) {
        return path.replace(".", File.separator);
    }

    static String path(Package pkg) {
        return path(pkg.getName());
    }

    static String srcMainResourcesPath(Package pkg) {
        return SRC_MAIN_RESOURCES + File.separator + path(pkg);
    }

    interface Files {


        static File directory(Package pkg) {
            return directory(pkg.getName());
        }

        static File directory(String destination) {
            File file = new File(SRC_MAIN_RESOURCES, Resources.path(destination));
            file.mkdirs();
            return file;
        }


        static File file(String destination, String name) {
            directory(destination);
            File file = new java.io.File(SRC_MAIN_RESOURCES, Resources.path(destination) + File.separator + name);
            try {
                file.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
            return file;
        }

        static File file(Package pkg, String fileName) {
            return file(pkg.getName(), fileName);
        }

        static void recursiveDelete(File file) {
            if(NOT_NULL.test(file)) {
                java.io.File parent = file.getParentFile();
                file.delete();
                if(NOT_NULL.and(HAS_NO_CHILDS).test(parent)) {
                    recursiveDelete(parent);
                }
            }
        }
    }

}
