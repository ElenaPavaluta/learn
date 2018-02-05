package oc.p.chapters.c_6_ExceptionsAndAssertions.usingMultiCatch;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeParseException;

class PracticeRun {

    public void doesNotCompile() { // METHOD DOES NOT COMPILE
        try {
            mightThrow();
        } catch(FileNotFoundException | IllegalStateException e) {  //although FNFE is not thrown directly the IOE is, and FNFE is a subclass of IOE
//        } catch(InputMismatchException e |MissingResourceException e){  //not valid syntax
//        } catch(SQLException | ArrayIndexOutOfBoundsException e){  //SQLException checked exception
//        } catch(FileNotFoundException | IllegalArgumentException e){  //FileNotFoundException already caught
//        } catch(Exception e){  //the more generic the exception is, the lower needs to be placed
        } catch(IOException e) {
        }
    }

    private void mightThrow() throws DateTimeParseException, IOException {
    }
}
