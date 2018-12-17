package utils.resources.files.util;

import java.nio.file.Path;

public interface PathUtil {
    static Path directory(Object obj) {
//        Path path = Paths.get(SLASH.separationOf(SRC_MAIN_RESOURCES), Resources.path(obj));
//        try {
//            path = Files.createDirectories(path);
//        } catch (IOException e) {
//            System.err.println("Resources.Path.directory(" + obj.getClass().getSimpleName() + ")");
//        }
//        return path;
        return null;
    }


    static Path file(Object obj, String fileName) {
//        directory(obj);
//        Path path = Paths.get(SLASH.separationOf(SRC_MAIN_RESOURCES), Resources.path(obj), fileName);
//        try {
//            path = Files.createFile(path);
//        } catch (IOException e) {
//            System.err.println("Resources.Path.file(" + obj.getClass().getSimpleName() + ", " + fileName + ")");
//        }
//        return path;
        return null;
    }

}
