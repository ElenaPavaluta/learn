package oc.p.chapters._6_ExceptionsAndAssertions.usingMultiCatch.tw;

import javax.activation.UnsupportedDataTypeException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

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
        } catch(IOException e) {}
//        } catch(SQLException e){   //the invocked method does not throw SQLException (checked exception)
//        }

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
        catch (RuntimeException e){

        }
        catch(FileNotFoundException e) {
        } catch(IOException e) {
        }
    }
}
