package oc.p.chapters._9_NIO2.understandingFileAttributes.discoveringBasicFileAttributes.ownership;

import utils.resources.files.Resources;
import utils.resources.files.util.PathUtil;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * public static UserPrincipal getOwner(Path path, LinkOption... options) throws IOException
 *
 * public static Path setOwner(Path path, UserPrincipal owner) throws IOException
 */

class Ownerhip {

    static Path path = PathUtil.directory(new Ownerhip());
    static Path ne = Paths.get("nonExistentPath");
    static List <Path> lst = Arrays.asList(path, ne);
    static Function <Path, UserPrincipal> GET_OWNER = p -> {
        try {
            return Files.getOwner(p);
        } catch (IOException e) {
            System.out.println(p + " doesn't have an owner");
            return null;
        }
    };

    static BiConsumer <Path, UserPrincipal> SET_OWNER = (p, u) -> {
        try {
            Files.setOwner(p, u);
        } catch (IOException e) {
            System.out.println(p + " can't have an owner");
        }
    };

    static void m() {
        lst.forEach(p ->
                System.out.println(GET_OWNER.apply(p) != null ? p : ""));
    }


    static void m2() {
        UserPrincipal userPrincipal = null;
        try {
            userPrincipal = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName(Resources.USER);
            m22(userPrincipal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void m22(final UserPrincipal userPrincipal) {
        Consumer <Path> consumer = p -> SET_OWNER.accept(p, userPrincipal);
        lst.forEach(consumer);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }

}
