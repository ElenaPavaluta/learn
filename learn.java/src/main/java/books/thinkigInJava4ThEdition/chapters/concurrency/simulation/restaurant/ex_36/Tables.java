package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.ex_36;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Tables {

    private BiPredicate<Table, Integer> biPredicate = (t, i) -> t.capacity() >= i;

    private List<Table> tables = Stream
            .<Table>generate(() -> new Table(Restaurant.rand.nextInt(Restaurant.MAX_TABLE_SEATS)))
            .limit(Restaurant.MAX_TABLE_SEATS)
            .collect(Collectors.toCollection(CopyOnWriteArrayList::new));

    synchronized Optional<Table> tableFor(int nbOfPerson) {
        Predicate<Table> predicate = t -> biPredicate.test(t, nbOfPerson);
        Optional<Table> optTable = tables.stream().filter(predicate).findFirst();
        optTable.ifPresent(tables::remove);
        return optTable;
    }

    synchronized void add(Table table) {
        tables.add(table);
    }
}
