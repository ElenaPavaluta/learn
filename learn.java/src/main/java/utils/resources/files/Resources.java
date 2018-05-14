package utils.resources.files;

import java.io.File;
import java.io.IOException;
import java.util.function.Predicate;

public interface Resources {
    String RESOURCES = "resources";
    String JAVA = "java";
    String SRC_MAIN = "src" + java.io.File.separator + "main";
    String SRC_MAIN_RESOURCES = SRC_MAIN + java.io.File.separator + RESOURCES;
    String SRC_MAIN_JAVA = SRC_MAIN + java.io.File.separator + JAVA;

    Predicate<java.io.File> NOT_NULL = file -> file != null;
    Predicate<java.io.File> HAS_NO_CHILDS = file -> file.listFiles().length == 0;

    interface Files {

        static String path(String currentPkg) {
            return currentPkg.replace(".", File.separator);
        }

        static java.io.File directory(String currentPkg) {
            java.io.File file = new File(SRC_MAIN_RESOURCES, path(currentPkg));
            file.mkdirs();
            return file;
        }

        static File file(String currentPkg, String name) {
            directory(currentPkg);
            File file = new java.io.File(SRC_MAIN_RESOURCES, path(currentPkg) + File.separator + name);
            try {
                file.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
            return file;
        }

        static void recursiveDelete(java.io.File file) {
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
