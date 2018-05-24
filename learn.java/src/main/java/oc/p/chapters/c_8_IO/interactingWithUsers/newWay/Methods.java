package oc.p.chapters.c_8_IO.interactingWithUsers.newWay;

import java.io.Console;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;

class Methods {
    Console console = System.console();

    Reader reader = console.reader();

    //Retrives a single line of text till the user presses Enter
    String  string = console.readLine();

    /**
     * Similar to readline() except that the echoing is disabled
     */
    char[] password = console.readPassword();

    Writer writer = console.writer();

    {
        /**
         * format(String, Object ...) behaves in a similar manner
         * as String.format(String, Object... )
         */
        console = console.format("Today is: " + LocalDate.now());
        console = console.printf("Today is: " + LocalDate.now());

        /**
         * Forces any buffered output to be written immediatly
         */
        console.flush();
    }


}
