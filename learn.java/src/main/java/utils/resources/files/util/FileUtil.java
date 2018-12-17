package utils.resources.files.util;

import utils.resources.files.Resources;

import java.io.File;
import java.io.IOException;

import static utils.resources.files.Separation.SLASH;

public interface FileUtil {
    static File directory(Object o) {
        File file = new File(SLASH.separationOf(Resources.SRC_MAIN_RESOURCES), SLASH.separationOf(o.getClass().getPackage().getName()));
        file.mkdirs();
        return file;
    }

    static File file(Object o, String fileName) {
        File dir = directory(o);
        File file = new File(dir, fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.err.println("Resources.File.file(" + o.getClass().getSimpleName() + ", " + fileName + ")");
        }
        return file;
    }

}
