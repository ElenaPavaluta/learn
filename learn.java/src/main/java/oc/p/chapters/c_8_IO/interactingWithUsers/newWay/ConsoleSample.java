package oc.p.chapters.c_8_IO.interactingWithUsers.newWay;

import java.io.Console;

/**
 * Console class is a singleton
 *
 * It is created automatically by the JVM: the System.console().
 * Will return null in environments where text interactions are not supported.
 */
class ConsoleSample {

    public static void main(String[] args) {
        Console console = System.console();
        if(console !=null){
            String userInput = console.readLine();
            console.writer().write("User entered: " + userInput);
        }
    }
}
