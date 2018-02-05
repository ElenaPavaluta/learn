package oc.p.chapters.c_6_ExceptionsAndAssertions.usingMultiCatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

class MultiCatch {

    static String file = Need.file;

    static void m() {
        try {
            Path path = Paths.get(file);
            String txt = new String(Files.readAllBytes(path)).trim();
            LocalDate localDate = LocalDate.parse(txt);
            System.out.println(localDate);
        } catch(DateTimeParseException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        m();
    }
}
