package books.thinkigInJava4ThEdition.chapters.generics.issues.noPrimitiveAsTypeParameter;

import java.util.ArrayList;
import java.util.List;

class ListOfInt {

    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            li.add(i);
        }

        li.forEach(System.out::println);
    }
}
