package books.thinkigInJava4ThEdition.chapters.generics.wildcards;

import java.util.List;

/**
 * FORBIDDEN: <T super MyClass>).
 */
class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples){
        apples.add(new Apple());
        apples.add(new Jonathan());
//        apples.add(new Fruit());  //compiler error
    }
}
