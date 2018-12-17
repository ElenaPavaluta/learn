package oc.p.chapters._9_NIO2.understandingFileAttributes.discoveringBasicFileAttributes.ownership.userPrincipal;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;
import utils.resources.files.util.PathUtil;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class UP {

    static Path path = PathUtil.directory(new UP());

    static Function <String, UserPrincipal> FROM_FILE_SYSTEMS = u -> {
        try {
            return FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName(u);
        } catch (IOException e) {
            System.out.println("FROM_FILE_SYSTEMS: " + u + " not found");
            return null;
        }
    };

    static Function <String, UserPrincipal> FROM_FILE_SYSTEM = u -> {
        try {
            return path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName(u);
        } catch (IOException e) {
            System.out.println("FROM_FILE_SYSTEM:" + u + " not found");
            return null;
        }
    };

    static Function <Path, UserPrincipal> FROM_PATH = p -> {
        try {
            return Files.getOwner(p);
        } catch (IOException e) {
            System.out.println("FROM_PATH:" + p + " not found");
            return null;
        }
    };

    static List <Function<String, UserPrincipal>> lst = Arrays.asList(FROM_FILE_SYSTEMS, FROM_FILE_SYSTEM);

    static void m() {
        mm(Resources.USER);
        Delimitators.equal();

        mm("john Doe");
        Delimitators.equal();

        System.out.println(FROM_PATH.apply(path));
    }

    private static void mm(final String user) {
        lst.forEach(f->{
            System.out.println(f.apply(user));
        });
    }

    public static void main(String[] args) {
        m();
    }
}
