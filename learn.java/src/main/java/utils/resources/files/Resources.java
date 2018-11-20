package utils.resources.files;

import oc.p.chapters._4_FunctionalProgramming.workingWithBuiltInFunctionalInterface.BiFunc;
import utils.print.Print;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

import static java.util.stream.Collectors.joining;

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
    BiFunction<PathRoot, java.nio.file.Path, Optional<java.nio.file.Path>> TO_PATH = (root, path)->{
        try {
            return Files.walk(root.path(), 1)
                    .filter(p->p.getFileName()!=null && path.startsWith(p.getFileName()))
                    .findFirst();
        } catch (IOException e) {
            return Optional.empty();
        }

    };

    static java.nio.file.Path propertiesFileAsPath(String name) {
        java.nio.file.Path path = Paths.get(SRC_MAIN_RESOURCES, name + DOT_PROPERTIES);
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
        return Resources.path(obj.getClass().getPackage());
    }

    static String path(Package pkg) {
        return Resources.path(pkg.getName());
    }

    static String srcMainResourcesPath(Package pkg) {
        return SRC_MAIN_RESOURCES + java.io.File.separator + Resources.path(pkg);
    }

    static String srcMainJavaPath(Object obj) {
        return srcMainJavaPath(obj.getClass().getPackage());
    }

    static String listResourceBundleFileName(Object obj) {
        return obj.getClass().getPackage().getName() + "." + obj.getClass().getSimpleName().split("_")[0];
    }

    static String srcMainJavaPath(Package pkg) {
        return SRC_MAIN_JAVA + java.io.File.separator + Resources.path(pkg);
    }

    static String srcMainResourcesPath(Object obj) {
        return srcMainResourcesPath(obj.getClass().getPackage());
    }

    static String absolutePath(Package pkg) {
        java.io.File file = new java.io.File(srcMainResourcesPath(pkg));
        return file.getAbsolutePath();
    }

    static void cleanSrcMainResources() {
        java.nio.file.Path path = Paths.get(SRC_MAIN_RESOURCES);
        deleteFromSrcMainResources(path);
    }


    static void deleteFromSrcMainResources(java.nio.file.Path base) {
        try {
            Files.walk(base)
                    .sorted(COMPARE_BY_DISTANCE_FROM_SOURCE.reversed())
                    .filter(p -> IS_SAME_FILE.negate().test(p, base))
                    .peek(System.out::println)
                    .forEach(DELETE_IF_EXISTS);
        } catch (IOException e) {
            System.err.println("Err: static void deleteFromSrcMainResources(Path base)");
        }
    }

    static void delete(java.nio.file.Path path) {
        Print.Delimitators.equal();
        System.out.println("delete -> " + path);

        Arrays.stream(PathRoot.values())
                .map(root ->TO_PATH.apply(root, path))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();


//        toDel.ifPresent( p-> {
//            try {
//                Files.walk(p)
//                        .sorted(COMPARE_BY_DISTANCE_FROM_SOURCE.reversed())
//                        .peek(System.out::println)
//                        .forEach(DELETE_IF_EXISTS);
//            } catch (IOException e) {
//                System.err.println("Err: delete(Path path) -> walk ");
//            }
//        });
    }


    interface Path {
        String NIO_FILE = "nio.file";

        static java.nio.file.Path directory(Object obj) {
            return directory(obj.getClass().getPackage());
        }

        static java.nio.file.Path directory(Package pkg) {
            java.nio.file.Path path = Paths.get(SRC_MAIN_RESOURCES, Resources.path(pkg));
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
            java.nio.file.Path path = Paths.get(SRC_MAIN_RESOURCES, Resources.path(pkg), Arrays.stream(dest).collect
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

        static java.nio.file.Path file(Object obj, String... dest) {
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
            java.io.File file = new java.io.File(SRC_MAIN_RESOURCES, Resources.path(destination));
            file.mkdirs();
            return file;
        }


        static java.io.File file(String destination, String name) {
            directory(destination);
            java.io.File file = new java.io.File(SRC_MAIN_RESOURCES, Resources.path(destination) + java.io.File
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
