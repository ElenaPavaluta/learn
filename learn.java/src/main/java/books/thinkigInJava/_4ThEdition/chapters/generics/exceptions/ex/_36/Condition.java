package books.thinkigInJava._4ThEdition.chapters.generics.exceptions.ex._36;

import java.util.function.Predicate;

interface Condition<T extends Predicate<T>> {

    boolean applyCond(T t);
}
