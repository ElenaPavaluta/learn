package books.thinkigInJava._4ThEdition.chapters.generics.exceptions.ex._36;

import java.util.function.Supplier;

interface Failure<T extends Supplier<T>> {

    T get();
}
