package utils.resources.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

import static java.util.Comparator.comparingInt;
import static utils.resources.files.Separation.SLASH;

public interface Resources {
    String IBM_CTANASE = "AzureAD\\CiprianDorinTanase";
    String USER = IBM_CTANASE;
    String DOT_PROPERTIES = ".properties";
    String SRC_MAIN_JAVA = "src.main.java";
    String SRC_MAIN_RESOURCES = "src.main.resources";
    String SRC_MAIN_RESOURCES_DB = "src.main.resources.db";

    Comparator <Path> COMPARE_BY_DISTANCE_FROM_SOURCE = comparingInt(Path::getNameCount);
    BiPredicate <Path, Path> IS_SAME_FILE = (p, p2) -> {
        try {
            return Files.isSameFile(p, p2);
        } catch (IOException e) {
            System.err.println("Resources.IS_SAME_FILE.apply(" + p + ", " + p2 + ")");
        }
        return false;
    };

    Consumer <Path> DELETE_IF_EXISTS = p -> {
        try {
            Files.deleteIfExists(p);
        } catch (IOException e) {
            System.err.println("Resources.DELETE_IF_EXISTS.apply(" + p + ")");
        }
    };


    static Path pathOfPropertyResourceBundle(String name) {
//        Path path = Paths.get(SLASH.separationOf(SRC_MAIN_RESOURCES), name + DOT_PROPERTIES);
//        if (!Files.exists(path)) {
//            try {
//                Files.createFile(path);
//            } catch (IOException e) {
//                System.err.println("Err: Files.createFile(path)");
//            }
//        }
//        return path;
        return null;
    }

    static Path pathOfPropertyResourceBundle(Object obj, String name) {
//        Path dir = Paths.get(SLASH.separationOf(SRC_MAIN_RESOURCES), S);
//        Path path = Paths.get(SLASH.separationOf(SRC_MAIN_RESOURCES), path(obj), name + DOT_PROPERTIES);
//        try {
//            Files.createDirectories(dir);
//            if (!Files.exists(path)) {
//                path = Files.createFile(path);
//            }
//        } catch (IOException e) {
//            System.err.println(String.format("Error: pathOfPropertyResourceBundle(%s, %s)", obj.getClass().getSimpleName(), name));
//        }
//        return path;
        return null;
    }

    static Path pathOfListResourceBundle(Object obj, String name) {
//        Path dir = Paths.get(SLASH.separationOf(SRC_MAIN_JAVA), path(obj));
//        Path path = Paths.get(SLASH.separationOf(SRC_MAIN_JAVA), path(obj), name + DOT_PROPERTIES);
//        try {
//            Files.createDirectories(dir);
//            if (!Files.exists(path)) {
//                path = Files.createFile(path);
//            }
//        } catch (IOException e) {
//            System.err.println(String.format("Error: pathOfListResourceBundle(%s, %s)", obj.getClass().getSimpleName(), name));
//        }
//        return path;
        return null;
    }

    static String srcMainResourcesPackagePath(Object obj) {
        return SLASH.separationOf(SRC_MAIN_RESOURCES) + java.io.File.separator + SLASH.separationOf(obj.getClass().getPackage().getName());
    }

    static void clean() {
        Path path = Paths.get(SLASH.separationOf(SRC_MAIN_RESOURCES));
        deleteFrom(path);
    }

    static void deleteFrom(Path path) {
        try {
            Files.walk(path)
                    .sorted(COMPARE_BY_DISTANCE_FROM_SOURCE.reversed())
                    .filter(p -> IS_SAME_FILE.negate().test(p, path))
                    .forEach(DELETE_IF_EXISTS);
        } catch (IOException e) {
            System.err.println("Resources.deleteFrom(" + path + ")");
        }
    }


    static String pathToPropertyResourceBundle(Package pkg, String prop) {
        return SLASH.separationOf(pkg.getName()) + File.separator + prop;
    }

    static String pathToListResourceBundle(Package pkg, String name) {
        return pkg.getName() + "." + name;
    }

    static File directory(Object o) {
        File file = new File(SLASH.separationOf(SRC_MAIN_RESOURCES),
                SLASH.separationOf(o.getClass().getPackage().getName()));
        file.mkdirs();
        return file;
    }

    static Path pathToFile(Object obj) {
        final Path dir = Paths.get(SLASH.separationOf(SRC_MAIN_RESOURCES),
                SLASH.separationOf(obj.getClass().getPackage().getName()));
        Path file = Paths.get(dir.toString(), obj.getClass().getSimpleName());
        try {
            Files.createDirectories(dir);
            if (!Files.exists(file)) {
                file = Files.createFile(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    static File pathToFile(Object o, String fileName) {
        File dir = directory(o);
        File file = new File(dir, fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.err.println("Resources.File.file(" + o.getClass().getSimpleName() + ", " + fileName + ")");
        }
        return file;
    }

}
