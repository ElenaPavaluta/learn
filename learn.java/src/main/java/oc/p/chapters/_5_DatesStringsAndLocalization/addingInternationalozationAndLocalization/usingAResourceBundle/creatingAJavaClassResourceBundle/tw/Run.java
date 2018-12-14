package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAJavaClassResourceBundle.tw;

import utils.resources.files.Location;
import utils.resources.files.Resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static utils.resources.files.Location.SRC_MAIN_RESOURCES;

class Run {

    static List <Path> toDel;

    static void move() throws IOException {
        String s = Resources.srcMainJavaPath(new Run());
        Path path = Paths.get(s);
        System.out.println(path);
        System.out.println(path.getFileName());

        Path dest = Paths.get(SRC_MAIN_RESOURCES.toPath());
        System.out.println(Files.exists(dest));

        Map <Path, Path> map = Files.list(path)
                .filter(p -> !p.getFileName().toString().contains(new Run().getClass().getSimpleName()))
                .peek(p -> System.out.println(p.getFileName()))
                .collect(toMap(Function.identity(), p -> Paths.get(SRC_MAIN_RESOURCES.toPath(), p.getFileName().toString())));
        toDel = map.values().stream().collect(toList());
        System.out.println(toDel);
        map.forEach((k, v) -> {
            try {
                Files.copy(k, v, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
            }
        });
    }

    static void read() {
        Locale l = Locale.FRANCE;
        String pkg = new Run().getClass().getPackage().getName();
        System.out.println(pkg);
//        ResourceBundle rb = ResourceBundle.getBundle("src.main.resources.Rb", l);
        ResourceBundle rb = ResourceBundle.getBundle(pkg + ".Rb", l);

        System.out.println(rb.getObject("cat").getClass());
        System.out.println(rb.getObject("lion").getClass());
        System.out.println(rb.getObject("dog").getClass());

    }

    public static void main(String[] args) throws IOException {
        move();
        read();
        Resources.clean();
    }
}
