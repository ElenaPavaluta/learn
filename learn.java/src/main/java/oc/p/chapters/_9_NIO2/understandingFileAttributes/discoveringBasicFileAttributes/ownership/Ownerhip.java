package oc.p.chapters._9_NIO2.understandingFileAttributes.discoveringBasicFileAttributes.ownership;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.UserPrincipal;

class Ownerhip {

    static Package pkg = new Ownerhip().getClass().getPackage();
    static Path dirPath = Paths.get(Resources.srcMainResourcesPath(pkg));

    static {
        try {
            dirPath = Files.createDirectories(dirPath);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static void m() throws IOException {
        System.out.println(Files.getOwner(dirPath));
    }

    static void m2() {
        /**
         * Obtain a FileSystem instance
         */
        FileSystem fs = FileSystems.getDefault();
        FileSystem fs2 = dirPath.getFileSystem();
    }

    static void m3(String user) {
        try {
            UserPrincipal userPrincipal = FileSystems.getDefault().getUserPrincipalLookupService()
                                                     .lookupPrincipalByName(user);
            System.out.println(userPrincipal);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static void m33(){
        m3(Resources.USER);
        m3("jane");
    }

    static void m44(){
        m4(Resources.USER);
        m4("jane");
    }

    static void m3344(){
        m33();
        m44();
    }

    static void m4(String user){
        try {
            UserPrincipal userPrincipal = dirPath.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName(user);
            System.out.println(userPrincipal);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static void m5() throws IOException {
        Path p = Paths.get(Resources.srcMainResourcesPath(pkg), new Ownerhip().getClass().getSimpleName());
        p = Files.createFile(p);

        System.out.println(p.getFileName());

        System.out.println(Files.getOwner(p));
        System.out.println(Files.getOwner(p).getName());

        UserPrincipal up = p.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName(Resources.USER);

        p = Files.setOwner(p, up);

        System.out.println("After set owner");
        System.out.println(Files.getOwner(p));

        Resources.recursiveDelete(dirPath, p);
    }

    public static void main(String[] args) throws IOException {
        m();
        Delimitators.equal();
//        m3344();

        m5();
    }
}
