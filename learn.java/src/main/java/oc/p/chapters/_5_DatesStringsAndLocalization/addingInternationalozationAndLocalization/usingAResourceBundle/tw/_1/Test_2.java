package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.tw._1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.ResourceBundle;

import utils.resources.files.Resources;

class Test_2 {

    static Path path = Resources.pathOfPropertyResourceBundle("a_de" + Resources.DOT_PROPERTIES);
    static Path path2 = Resources.pathOfPropertyResourceBundle("a_de_DE" + Resources.DOT_PROPERTIES);

    static {
        try {
            if (!Files.exists(path)) {
                path = Files.createFile(path);
                try (BufferedWriter bw = Files.newBufferedWriter(path)) {
                    bw.write("p: prop");
                }
            }
            if (!Files.exists(path2)) {
                path2 = Files.createFile(path2);
            }
        } catch (IOException e) {
        }
    }

    static void m() {
        ResourceBundle  rb = ResourceBundle.getBundle("a", Locale.GERMANY);
        System.out.println(rb.getString("p"));
    }

    public static void main(String[] args) {
        m();
    }
}

