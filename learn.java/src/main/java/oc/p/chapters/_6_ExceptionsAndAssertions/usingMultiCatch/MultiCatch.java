package oc.p.chapters._6_ExceptionsAndAssertions.usingMultiCatch;

import utils.resources.files.Resources;
import utils.resources.files.create.populate.CreatePopulate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

class MultiCatch {


    static Path path = CreatePopulate.NIO.file(new MultiCatch().getClass().getPackage());

    static void oldWay() {
        try {
            String txt = new String(Files.readAllBytes(path)).trim();
            LocalDate localDate = LocalDate.parse(txt);
            System.out.println(localDate);
        } catch(DateTimeParseException e) {
            handleEx(e);
        } catch(IOException e) {
            handleEx(e);
        }
    }

    private static void handleEx(Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }


    static void newWay() {
        try {
            String txt = new String(Files.readAllBytes(path)).trim();
            LocalDate localDate = LocalDate.parse(txt);
            System.out.println(localDate);
        } catch(DateTimeParseException | IOException e) {
            handleEx(e);
        }
    }

    public static void main(String[] args) {
//        oldWay();
//        newWay();
        Resources.recursiveDelete(path);
    }
}
