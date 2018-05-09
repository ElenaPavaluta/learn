package books.thinkigInJava._4ThEdition.chapters.generics.genericMethods.varargsAndGenericMethods;

import java.util.Arrays;
import java.util.List;

class GenericVarrargs {

    static <T> List<T> makeList(T... args){
        return Arrays.asList(args);
    }

    public static void main(String[] args) {
        List<String> lst = makeList("A");
        System.out.println(lst);

        lst = makeList("A", "B", "C");
        System.out.println(lst);

        lst = makeList("ABCDEFFHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(lst);
    }
}
