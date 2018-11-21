//package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.create.file;
//
//import utils.resources.files.Resources;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
///**
// * static Path	createFile(Path path, FileAttribute<?>... attrs)
// * Creates a new and empty file, failing if the file already exists.
// *
// * static Path	createLink(Path link, Path existing)
// * Creates a new link (directory entry) for an existing file (optional operation).
// *
// * static Path	createSymbolicLink(Path link, Path target, FileAttribute<?>... attrs)
// * Creates a symbolic link to a target (optional operation).
// */
//class CreateSymbolicLink {
//
//    static CreateSymbolicLink CSL = new CreateSymbolicLink();
//    static Path dir = Resources.Path.directory(CSL, "csl", "a", "b");
//
//    static void m() throws IOException {
//        Path p = Paths.get(Resources.srcMainResourcesPath(CSL));
//
//        p = Files.createSymbolicLink(p, dir);
//    }
//
//    static void m2() {
//        Path target = Paths.get(dir.toString(), "a.txt");
//        try {
//            target = Files.createFile(target);
//        } catch (IOException e) {
//            System.err.println("Err creating target");
//        }
//
//        Path p = Paths.get(Resources.srcMainResourcesPath(CSL));
//        try {
//            p = Files.createSymbolicLink(p, target);
//        } catch (IOException e) {
//            System.err.println("Err creating symbolic link");
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
////        m();  //IOE
//        m2();
//
//        Resources.clean();
//    }
//}
