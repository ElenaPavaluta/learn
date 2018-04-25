package books.thinkigInJava4ThEdition.chapters.generics.buildingComplexModels;

import books.thinkigInJava4ThEdition.chapters.generics.genericMethods.simplifyingTupleUse.FourTuple;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.function.Supplier;

class TupleList<A, B, C, D> extends ArrayList<FourTuple<A, B, C, D>> {

    FourTuple<A, B, C, D> entity(Supplier<A> sa, Supplier<B> sb, Supplier<C> sc, Supplier<D> sd){
        return new FourTuple<>(sa.get(), sb.get(), sc.get(), sd.get());
    }

    public static void main(String[] args) {
        TupleList<LocalDate, LocalDateTime, ZonedDateTime, Instant> tuples = new TupleList<>();
        tuples.add(tuples.entity(LocalDate::now, LocalDateTime::now, ZonedDateTime::now, Instant::now));
        tuples.add(tuples.entity(LocalDate::now, LocalDateTime::now, ZonedDateTime::now, Instant::now));
        tuples.forEach(System.out::println);
    }
}
