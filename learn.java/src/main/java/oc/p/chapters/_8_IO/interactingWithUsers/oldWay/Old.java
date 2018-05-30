package oc.p.chapters._8_IO.interactingWithUsers.oldWay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Old {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String userInput = reader.readLine();

        System.out.println("You entered: " + userInput);
    }
}
