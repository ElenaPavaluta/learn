package interview.google.delChar;

import java.util.ArrayList;
import java.util.List;

/**
 * char de = '<'
 * String s = "aaa<a";
 * String s2 = "aaabbb<<<";
 */
class DelChar {
    static char DEL_CHAR = '<';

    public static void main(String[] args) {
        m();
    }

    static String transform(String input) {
        List <Integer> toDel = new ArrayList <>();
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == DEL_CHAR) {
                toDel.add(i);
                toDel.add(posToDel(toDel, i));
            }
        }
        toDel.forEach(i -> chars[i] = ' ');

        String output = String.valueOf(chars).replaceAll(" ", "");
        System.out.println(output.length());
        return output;
    }

    private static int posToDel(final List <Integer> toDel, final int i) {
        return toDel.size() == 1 ? i - 1 : toDel.get(toDel.size() - 2) - 1;
    }

    static void m() {
        System.out.println(transform("aaa<a"));
        System.out.println(transform("aaabbb<<<"));
    }
}
