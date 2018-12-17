package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAPropertyFileResourceBundle.propertyFileFormat;

import utils.resources.files.Resources;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;

import static utils.resources.files.Resources.DOT_PROPERTIES;
import static utils.resources.files.Resources.SRC_MAIN_RESOURCES;
import static utils.resources.files.Separation.SLASH;

class Prop {

    public static final String P = "prop";
    static Path de, de_De, prop;

    static {
        de_De = Paths.get(SLASH.separationOf(SRC_MAIN_RESOURCES), P + "_de_De" + DOT_PROPERTIES);
        de = Paths.get(SLASH.separationOf(SRC_MAIN_RESOURCES), P + "_de" + DOT_PROPERTIES);
        prop = Paths.get(SLASH.separationOf(SRC_MAIN_RESOURCES), P + DOT_PROPERTIES);

        init(de_De, "colon:Colon");
        init(de, "equal=Equal");
        init(prop, "space Space");
    }

    private static void init(Path de, String content) {
        if (!Files.exists(de)) {
            try {
                de = Files.createFile(de);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (BufferedWriter bw = Files.newBufferedWriter(de)) {
                bw.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void m() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(P, Locale.GERMANY);
        System.out.println(resourceBundle.getString("colon"));
        System.out.println(resourceBundle.getString("equal"));
        System.out.println(resourceBundle.getString("space"));
    }

    public static void main(String[] args) {
        m();
        Resources.clean();
    }
}
