package books.thinkigInJava._4ThEdition.chapters.generics.exceptions.ex._36;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface SingleProcess<T extends Predicate<T>, U extends Supplier<U>> {

    Optional<Failure<U>> process(Condition<T> cond);
}
