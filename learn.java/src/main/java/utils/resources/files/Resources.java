package utils.resources.files;

import java.io.File;
import java.io.IOException;

public interface Resources {
    String RESOURCES = "resources";
    String JAVA = "java";
    String SRC_MAIN = "src" + File.separator + "main";
    String SRC_MAIN_RESOURCES = SRC_MAIN + File.separator + RESOURCES;
    String SRC_MAIN_JAVA = SRC_MAIN + File.separator + JAVA;

    interface Files {

        static String path(String currentPkg) {
            String dir = currentPkg.replace(".", File.separator);
            dir = SRC_MAIN_RESOURCES + File.separator + dir;
            return dir;
        }

        static String pathWithSeparator(String currentPkg){
            return path(currentPkg) + File.separator;
        }

        static File directory(String currentPkg) {
            File file = new File(path(currentPkg));
            file.mkdirs();
            return file;
        }

        static File file(String currentPkg, String name) {
            File file = new File(pathWithSeparator(currentPkg) + name);
            try {
                file.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
            return file;
        }

        static void del(String currentPkg) {
            File file = directory(currentPkg);
            file.delete();
        }

        static void delAll(){
            File file = new File(path(SRC_MAIN_RESOURCES));
            file.delete();
        }
    }

}
