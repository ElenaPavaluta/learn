package utils.resources.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;

import static utils.resources.files.Resources.path;

public interface Resources {
    String RESOURCES = "resources";
    String JAVA = "java";
    String SRC_MAIN = "src" + java.io.File.separator + "main";
    String SRC_MAIN_RESOURCES = SRC_MAIN + java.io.File.separator + RESOURCES;
    String SRC_MAIN_JAVA = SRC_MAIN + java.io.File.separator + JAVA;

    static String path(String path) {
        return path.replace(".", java.io.File.separator);
    }

    static String path(Package pkg) {
        return path(pkg.getName());
    }

    static String srcMainResourcesPath(Package pkg) {
        return SRC_MAIN_RESOURCES + java.io.File.separator + path(pkg);
    }

    static String srcMainResourcesPath(Object obj) {
        return srcMainResourcesPath(obj.getClass().getPackage());
    }

    static String absolutePath(Package pkg) {
        java.io.File file = IO.File.directory(pkg);
        String absolutePath = file.getAbsolutePath();
        IO.File.recursiveDelete(file);
        return absolutePath;
    }

    static void recursiveDelete(Object... resources) {
        Arrays.stream(resources).forEach(resource -> {
            if(resource instanceof File) {
                IO.File.recursiveDelete((File) resource);
            } else if(resource instanceof Path) {
                NIO.Path.recursiveDelete((Path) resource);
            }
        });
    }

    static void recursiveDelete(Collection<Object> collection) {
        recursiveDelete(collection.toArray(new Object[0]));
    }

    interface IO {
        interface File {

            Predicate<java.io.File> NOT_NULL = file -> file != null;
            Predicate<java.io.File> HAS_NO_CHILDS = file -> file.listFiles().length == 0;

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
                } catch(IOException e) {
                    e.printStackTrace();
                }
                return file;
            }

            static java.io.File file(Package pkg, String fileName) {
                return file(pkg.getName(), fileName);
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

            static void recursiveDelete(Collection<java.io.File> collection) {
                collection.forEach(IO.File::recursiveDelete);
            }

            static void recursiveDelete(java.io.File... files) {
                Arrays.stream(files).forEach(File::recursiveDelete);
            }
        }
    }

    interface NIO {
        interface Path {
            java.nio.file.Path SRC_MAIN_RESOURCES_PATH = Paths.get(SRC_MAIN_RESOURCES);
            Predicate<java.nio.file.Path> IS_SRC_MAIN_RESOURCES_PATH = path -> {
                try {
                    return Files.isSameFile(path, SRC_MAIN_RESOURCES_PATH);
                } catch(IOException e) {
                    return false;
                }
            };

            Predicate<java.nio.file.Path> EXISTS = Files::exists;
            Predicate<java.nio.file.Path> SYMBOLIC_LINK = Files::isSymbolicLink;

            static java.nio.file.Path directory(Package pkg) {
                return IO.File.directory(pkg).toPath();
            }

            static java.nio.file.Path file(Package pkg, String fileName) {
                return IO.File.file(pkg, fileName).toPath();
            }

            static void recursiveDelete(Collection<java.nio.file.Path> collection) {
                collection.forEach(NIO.Path::recursiveDelete);
            }

            static void recursiveDelete(java.nio.file.Path... paths) {
                Arrays.stream(paths).forEach(NIO.Path::recursiveDelete);
            }

            static void recursiveDelete(java.nio.file.Path path) {
                if(EXISTS.or(SYMBOLIC_LINK).test(path)) {
                    while(IS_SRC_MAIN_RESOURCES_PATH.negate().test(path)) {
                        java.nio.file.Path parent = path.getParent();
                        try {
                            Files.deleteIfExists(path);
                            path = parent;
                        } catch(IOException e) {
                            break;
                        }
                    }
                }
            }
        }
    }
}
