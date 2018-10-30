package oc.p.chapters._9_NIO2.understandingFileAttributes.discoveringBasicFileAttributes.fileAccessibility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * Methods that do not throw exceptions if the file does not exist, just return false
 * isDirectory(),
 * isRegularFile(),
 * isSymbolicLink(),
 * isReadable()
 * isExecutable()
 *
 * isHidden() throws an exception if the file does not exists
 */
class PathIsVsFileIs {

    static Predicate <Path> PATH_IS_DIRECTORY = Files::isDirectory;
    static Predicate <Path> PATH_IS_REGULAR_FILE = Files::isRegularFile;
    static Predicate <Path> PATH_IS_SYMBOLIC_LINK = Files::isSymbolicLink;
    static Predicate <Path> PATH_IS_READABLE = Files::isReadable;
    static Predicate <Path> PATH_IS_EXECUTABLE = Files::isExecutable;
    static Predicate <Path> PATH_IS_HIDDEN = p -> {
        try {
            return Files.isHidden(p);
        } catch (IOException e) {
            System.err.println("File doesn't exists");
        }
        return false;
    };
    static BiPredicate <Path, Path> PATH_IS_SAME_FILE = (p, p2) -> {
        try {
            return Files.isSameFile(p, p2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    };
    
    static Predicate <File> FILE_IS_DIRECTORY = File::isDirectory;
    static Predicate <File> FILE_IS_FILE = File::isFile;
    static Predicate <File> FILE_IS_HIDDEN = File::isHidden;

    static Predicate <File> FILE_IS_ABSOLUTE = File::isAbsolute;


}
