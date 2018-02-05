package oc.p.chapters.c_6_ExceptionsAndAssertions.usingMultiCatch.tw;

import javax.activation.UnsupportedDataTypeException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

class SubsclassException {

    public static void main(String[] args) {
        SubsclassException se = new SubsclassException();
        se.m();
    }

    void ioe() throws IOException {
    }

    void m() {
        try {
            ioe();
        } catch(EOFException e) {
        } catch(UnsupportedDataTypeException e) {
        } catch(FileNotFoundException e) {
        } catch(IOException e) {
        }
    }

    void m2() {
        try {
            ioe();
        } catch(IOException e) {
        }
    }

    void m3() {
        try {
            ioe();
        } /*catch(SQLException e){}*/  //compiler error: isn't thrown by any other class
        catch(FileNotFoundException e) {
        } catch(IOException e) {
        }
    }
}
