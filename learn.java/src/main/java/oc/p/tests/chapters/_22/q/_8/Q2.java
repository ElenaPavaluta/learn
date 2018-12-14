package oc.p.tests.chapters._22.q._8;

import utils.resources.files.Resources;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import static utils.resources.files.Location.SRC_MAIN_RESOURCES;

class Q2 {

    static Path path;

    static void m() throws IOException {
        Path root = Paths.get(SRC_MAIN_RESOURCES.toPath(), "a", "b");
        Files.createDirectories(root);
        System.out.println(root);

        path = Paths.get(SRC_MAIN_RESOURCES.toPath(), "a", "b", "c_en_US" + Resources.DOT_PROPERTIES);
        if (!Files.exists(path)) path = Files.createFile(path);

        System.out.println(path);
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            bw.write("a:A");
        }
    }

    static void m2() {
//        ResourceBundle rb = ResourceBundle.getBundle("a\\b\\c");  //this also works
        final String baseName = Resources.pathToPropertyResourceBundle(path);
        System.out.println(path);
        System.out.println(baseName);
        ResourceBundle rb = ResourceBundle.getBundle(baseName);

        System.out.println(rb.getString("a"));
//        System.out.println(rb.getString("b"));  //RE MissingResourceException
    }

    public static void main(String[] args) throws IOException {
        m();
        m2();

        Resources.clean();
    }
}
