package oc.p.chapters._6_ExceptionsAndAssertions.usingMultiCatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

class Need {

    static String file = "D:\\workspace\\cip\\learn\\learn.java\\src\\main\\java\\oc\\p\\chapters\\c_6_ExceptionsAndAssertions\\usingMultiCatch\\born";

    static void m() {
        try {
            Path path = Paths.get(file);
            String txt = new String(Files.readAllBytes(path)).trim();
            LocalDate localDate = LocalDate.parse(txt);
            System.out.println(localDate);
        } catch(DateTimeParseException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);

        } catch(IOException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    //although the exception handling is done in a method, calling it twice is still a redundancy
    static void m2() {
        try {
            Path path = Paths.get(file);
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
        throw  new RuntimeException(e);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
