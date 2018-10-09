package gtk.tw.date._2018.october._1;

import java.util.Arrays;
import java.util.stream.Collectors;

class Q2 {

    public static void main(String[] args) {
        String s = "ANA_ARE_MERE";
        String collect = Arrays.stream(s.split("_")).map(String::toLowerCase).collect(Collectors.joining(" "));
        System.out.println(collect.replace(collect.charAt(0), String.valueOf(collect.charAt(0)).toUpperCase().charAt(0)));
    }
}
