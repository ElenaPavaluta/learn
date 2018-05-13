package books.thinkigInJava._4ThEdition.chapters.generics.exceptions.tw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class C {

    private static final E[] arr = {E.A, E.B};

    private static final ArrayList<E> arl = new ArrayList<>();
    static {
        arl.add(E.A);
        arl.add(E.B);
    }

    private static final List<E> lst = Collections.unmodifiableList(arl);

    static {
        arr[0] = E.C;
        System.out.println(Arrays.toString(arr));
        lst.set(0, E.C);
        System.out.println(lst);
    }

    enum E{A, B, C}

    public static void main(String[] args) {

    }
}
