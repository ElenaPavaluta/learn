package books.thinkigInJava._4ThEdition.chapters.generics.issues.noPrimitiveAsTypeParameter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ByteSet {

    Byte[] possibles = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    Set<Byte> set = new HashSet<>(Arrays.asList(possibles));

    Set<Byte> set2 = new HashSet<Byte>(Arrays.<Byte>asList(possibles));

    public static void main(String[] args) {
        ByteSet bs = new ByteSet();

        System.out.println(Arrays.toString(bs.possibles));

        bs.set.forEach(System.out::println);
        bs.set2.forEach(System.out::println);
    }
}
