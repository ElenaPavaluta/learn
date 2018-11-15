package interview.google.delChar;

import java.util.ArrayDeque;
import java.util.Deque;

import static java.util.stream.Collectors.joining;

/**
 * char de = '<'
 * String s = "aaa<a";
 * String s2 = "aaabbb<<<";
 */

class DelChar2 {

    static char DEL_CHAR = '<';

    static String transform(String input) {
        char[] chars = input.toCharArray();
        Deque <Character> deque = new ArrayDeque <>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == DEL_CHAR) {
                if(deque.size()>0){
                    deque.pop();
                }
            } else {
                deque.push(chars[i]);
            }
        }
        return deque.stream()
                .map(String::valueOf)
                .collect(joining());
    }

    static void m() {
        System.out.println(transform("aaa<a"));
        System.out.println(transform("aaabbb<<<"));
    }

    public static void main(String[] args) {
        m();
    }
}
