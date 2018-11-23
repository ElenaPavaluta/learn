package utils.resources.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

import static java.util.Comparator.comparingInt;
import static utils.resources.files.Location.SRC_MAIN_JAVA;
import static utils.resources.files.Location.SRC_MAIN_RESOURCES;

public interface Resources {
    String IBM_CTANASE = "AzureAD\\CiprianDorinTanase";
    String USER = IBM_CTANASE;
    String DOT_PROPERTIES = ".properties";

    Comparator <java.nio.file.Path> COMPARE_BY_DISTANCE_FROM_SOURCE = comparingInt(java.nio.file.Path::getNameCount);

    BiPredicate <java.nio.file.Path, java.nio.file.Path> IS_SAME_FILE = (p, p2) -> {
        try {
            return Files.isSameFile(p, p2);
        } catch (IOException e) {
            System.err.println("Resources.IS_SAME_FILE.apply(" + p + ", " + p2 + ")");
        }
        return false;
    };
    Consumer <java.nio.file.Path> DELETE_IF_EXISTS = p -> {
        try {
            Files.deleteIfExists(p);
        } catch (IOException e) {
            System.err.println("Resources.DELETE_IF_EXISTS.apply(" + p + ")");
        }
    };

    static java.nio.file.Path propertiesFileAsPath(String name) {
        java.nio.file.Path path = Paths.get(SRC_MAIN_RESOURCES.toPath(), name + DOT_PROPERTIES);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.err.println("Err: Files.createFile(path)");
            }
        }
        return path;
    }

    static String path(String path) {
        return path.replace(".", java.io.File.separator);
    }

    static String path(Object obj) {
        return path(obj.getClass().getPackage().getName());
    }

    static String listResourceBundleFileName(Object obj) {
        return obj.getClass().getPackage().getName() + "." + obj.getClass().getSimpleName().split("_")[0];
    }

    static String srcMainResourcesPath(Object obj) {
        return SRC_MAIN_RESOURCES.toPath() + java.io.File.separator + path(obj);
    }

    static String srcMainJavaPath(Object obj) {
        return SRC_MAIN_JAVA.toPath() + java.io.File.separator + path(obj);
    }

    static void clean() {
        java.nio.file.Path path = Paths.get(SRC_MAIN_RESOURCES.toPath());
        deleteFrom(path);
    }

    static void deleteFrom(java.nio.file.Path path) {
        try {
            Files.walk(path)
                    .sorted(COMPARE_BY_DISTANCE_FROM_SOURCE.reversed())
                    .filter(p -> IS_SAME_FILE.negate().test(p, path))
                    .peek(System.out::println)
                    .forEach(DELETE_IF_EXISTS);
        } catch (IOException e) {
            System.err.println("Resources.deleteFrom(" + path + ")");
        }
    }

    interface Path {
        static java.nio.file.Path directory(Object obj) {
            java.nio.file.Path path = Paths.get(SRC_MAIN_RESOURCES.toPath(), path(obj));
            try {
                path = Files.createDirectories(path);
            } catch (IOException e) {
                System.err.println("Resources.Path.directory(" + obj.getClass().getSimpleName() + ")");
            }
            return path;
        }


        static java.nio.file.Path file(Object obj, String fileName) {
            directory(obj);
            java.nio.file.Path path = Paths.get(SRC_MAIN_RESOURCES.toPath(), path(obj), fileName);
            try {
                path = Files.createFile(path);
            } catch (IOException e) {
                System.err.println("Resources.Path.file(" + obj.getClass().getSimpleName() + ", " + fileName + ")");
            }
            return path;
        }

    }

    interface File {
        static java.io.File directory(Object o) {
            java.io.File file = new java.io.File(SRC_MAIN_RESOURCES.toPath(), path(o.getClass().getPackage().getName()));
            file.mkdirs();
            return file;
        }

        static java.io.File file(Object o, String fileName) {
            java.io.File dir = directory(o);
            java.io.File file = new java.io.File(dir, fileName);
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Resources.File.file(" + o.getClass().getSimpleName() + ", " + fileName + ")");
            }
            return file;
        }

    }
}
