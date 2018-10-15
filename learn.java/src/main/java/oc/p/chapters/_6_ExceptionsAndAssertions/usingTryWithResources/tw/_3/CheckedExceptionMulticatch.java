package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw._3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.sql.SQLException;
import java.text.ParseException;

class CheckedExceptionMulticatch {
    static int a = 5;

    static void old() {
        try {
            if (a > 1) throw new ParseException("", 0);
            if (a > 2) throw new SQLException();
            if (a > 3) throw new NotSerializableException();
            if (a > 4) throw new FileNotFoundException();
            if (a > 5) throw new IOException();

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NotSerializableException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void multiCatch() {
        try {
            if (a > 5) throw new IOException();
            if (a > 4) throw new FileNotFoundException();
            if (a > 3) throw new NotSerializableException();
            if (a > 2) throw new SQLException();
            if (a > 1) throw new ParseException("", 0);
        } catch (ParseException | SQLException /*| NotSerializableException | FileNotFoundException*/ | IOException e) {
        }
    }
}