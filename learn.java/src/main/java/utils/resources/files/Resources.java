package utils.resources.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static utils.resources.files.Resources.path;

public interface Resources {
    String RESOURCES = "resources";
    String JAVA = "java";
    String SRC_MAIN = "src" + java.io.File.separator + "main";
    String SRC_MAIN_RESOURCES = SRC_MAIN + java.io.File.separator + RESOURCES;
    String SRC_MAIN_JAVA = SRC_MAIN + java.io.File.separator + JAVA;

    Predicate<java.io.File> NOT_NULL = file -> file != null;
    Predicate<java.io.File> HAS_NO_CHILDS = file -> file.listFiles().length == 0;

    static String path(String path) {
        return path.replace(".", java.io.File.separator);
    }

    static String path(Package pkg) {
        return path(pkg.getName());
    }

    static String srcMainResourcesPath(Package pkg) {
        return SRC_MAIN_RESOURCES + java.io.File.separator + path(pkg);
    }

    static String absolutePath(Package pkg) {
        java.io.File file = IO.File.directory(pkg);
        String absolutePath = file.getAbsolutePath();
        IO.File.recursiveDelete(file);
        return absolutePath;
    }

    interface IO {
        interface File {

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

            static void recursiveDelete(java.io.File... files) {
                Arrays.stream(files).forEach(File::recursiveDelete);
            }
        }
    }

    interface NIO2 {
        interface Path {
            static java.nio.file.Path directory(Package pkg) {
                return IO.File.directory(pkg).toPath();
            }

            static java.nio.file.Path file(Package pkg, String fileName) {
                return IO.File.file(pkg, fileName).toPath();
            }

            static void recursiveDelete(java.nio.file.Path... paths) {
                List<java.io.File> temp = new ArrayList<>();
                Arrays.asList(paths).forEach(p -> {
                    try {
                        p.toRealPath(LinkOption.NOFOLLOW_LINKS);
                        temp.add(p.toFile());
                    } catch(IOException e) {
                        //means that p is not a real file (file or directory)
                    }
                });
                IO.File.recursiveDelete(temp.toArray(new java.io.File[0]));
            }
        }
    }
}
