package utils.resources.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.stream.Collectors.joining;
import static utils.resources.files.Resources.path;

public interface Resources {
    String IBM_CTANASE = "AzureAD\\CiprianDorinTanase";
    String USER = IBM_CTANASE;
    String RESOURCES = "resources";
    String JAVA = "java";
    String SRC_MAIN = "src" + java.io.File.separator + "main";
    String SRC_MAIN_RESOURCES = SRC_MAIN + java.io.File.separator + RESOURCES;
    String SRC_MAIN_RESOURCES_DB = SRC_MAIN_RESOURCES + java.io.File.separator + "db";
    String SRC_MAIN_JAVA = SRC_MAIN + java.io.File.separator + JAVA;
    String DOT_PROPERTIES = ".properties";
    Comparator <java.nio.file.Path> COMPARE_BY_DISTANCE_FROM_SOURCE = Comparator.comparingInt(java.nio.file.Path::getNameCount);
    BiPredicate <java.nio.file.Path, java.nio.file.Path> IS_SAME_FILE = (p, p2) -> {
        try {
            return Files.isSameFile(p, p2);
        } catch (IOException e) {
            System.err.println("Err: BiPredicate <Path, Path> IS_SAME_FILE");
        }
        return false;
    };

    Consumer <java.nio.file.Path> DELETE_IF_EXISTS = p -> {
        try {
            Files.deleteIfExists(p);
        } catch (IOException e) {
            System.err.println("Err: Consumer <Path> DELETE_IF_EXISTS");
        }
    };

    static java.nio.file.Path propertiesFilesPath(String name) {
        return Paths.get(SRC_MAIN_RESOURCES, name + DOT_PROPERTIES);
    }

    static String path(String path) {
        return path.replace(".", java.io.File.separator);
    }

    static String path(Package pkg) {
        return path(pkg.getName());
    }

    static String srcMainResourcesPath(Package pkg) {
        return SRC_MAIN_RESOURCES + java.io.File.separator + path(pkg);
    }

    static String srcMainJavaPath(Package pkg) {
        return SRC_MAIN_JAVA + java.io.File.separator + path(pkg);
    }

    static String srcMainResourcesPath(Object obj) {
        return srcMainResourcesPath(obj.getClass().getPackage());
    }

    static String absolutePath(Package pkg) {
        java.io.File file = new java.io.File(srcMainResourcesPath(pkg));
        return file.getAbsolutePath();
    }

    static void clean() {
        java.nio.file.Path path = Paths.get(SRC_MAIN_RESOURCES);
        recursiveDelete(path);
    }

    static void recursiveDelete(Object... resources) {
        Arrays.stream(resources).forEach(resource -> {
            if (resource instanceof File) {
                recursiveDelete(((java.io.File) resource).toPath());
            } else if (resource instanceof Path) {
                recursiveDelete(resource);
            }
        });
    }

    static void recursiveDelete(java.nio.file.Path base) {
        try {
            Files.walk(base)
                    .sorted(COMPARE_BY_DISTANCE_FROM_SOURCE.reversed())
                    .filter(p -> IS_SAME_FILE.negate().test(p, base))
                    .forEach(DELETE_IF_EXISTS);
        } catch (IOException e) {
            System.err.println("Err: static void recursiveDelete(Path base)");
        }
    }

    static void recursiveDelete(Collection <Object> collection) {
        recursiveDelete(collection.toArray(new Object[0]));
    }

    interface Path {
        String NIO_FILE = "nio.file";


        Predicate <java.nio.file.Path> EXISTS = Files::exists;
        Predicate <java.nio.file.Path> SYMBOLIC_LINK = Files::isSymbolicLink;

        static java.nio.file.Path directory(Object obj) {
            return directory(obj.getClass().getPackage());
        }

        static java.nio.file.Path directory(Package pkg) {
            java.nio.file.Path path = Paths.get(SRC_MAIN_RESOURCES, path(pkg));
            try {
                path = Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return path;
        }

        static java.nio.file.Path directory(Object obj, String... dest) {
            return directory(obj.getClass().getPackage(), dest);
        }

        static java.nio.file.Path directory(Package pkg, String... dest) {
            java.nio.file.Path path = Paths.get(SRC_MAIN_RESOURCES, path(pkg), Arrays.stream(dest).collect
                    (joining(java.io.File.separator)));
            try {
                path = Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return path;
        }

        static java.nio.file.Path file(Object obj, String fileName) {
            return file(obj.getClass().getPackage(), fileName);
        }

        static java.nio.file.Path file(Package pkg, String fileName) {
            java.nio.file.Path path = Paths.get(directory(pkg).toString(), fileName);
            try {
                path = Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return path;
        }

        static java.nio.file.Path file(Object obj, String... dest){
            return file(obj.getClass().getPackage(), dest);
        }

        static java.nio.file.Path file(Package pkg, String... dest) {
            switch (dest.length) {
                case 0:
                    return file(pkg, NIO_FILE);
                case 1:
                    return file(pkg, dest[0]);
                default:
                    java.nio.file.Path path = null;
                    try {
                        path = directory(pkg, Arrays.copyOf(dest, dest.length - 1));
                        path = Files.createFile(Paths.get(path.toString(), dest[dest.length - 1]));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return path;
            }
        }

    }

    interface File {
        static java.io.File directory(Object o) {
            return directory(o.getClass().getPackage());
        }

        static java.io.File directory(Package pkg) {
            return directory(pkg.getName());
        }

        static java.io.File directory(String destination) {
            java.io.File file = new java.io.File(SRC_MAIN_RESOURCES, path(destination));
            file.mkdirs();
            return file;
        }


        static java.io.File file(String destination, String name) {
            directory(destination);
            java.io.File file = new java.io.File(SRC_MAIN_RESOURCES, path(destination) + java.io.File
                    .separator + name);
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return file;
        }

        static java.io.File file(Object o, String fileName) {
            return file(o.getClass().getPackage(), fileName);
        }

        static java.io.File file(Package pkg, String fileName) {
            return file(pkg.getName(), fileName);
        }

    }
}
