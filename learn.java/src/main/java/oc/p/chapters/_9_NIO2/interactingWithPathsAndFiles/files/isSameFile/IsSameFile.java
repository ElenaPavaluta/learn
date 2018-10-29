package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.isSameFile;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * static boolean	isSameFile(Path file, Path path2)
 *
 * Tests if two paths locate the same file.
 *
 * This isSameFile() method does not compare the contents of the file. For
 * example, two files may have identical content and attributes, but if they
 * are in different locations, then this method will return false .
 */
class IsSameFile {


}
