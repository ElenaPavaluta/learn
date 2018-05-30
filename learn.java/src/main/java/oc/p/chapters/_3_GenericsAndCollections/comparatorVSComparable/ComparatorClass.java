package oc.p.chapters._3_GenericsAndCollections.comparatorVSComparable;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.ResourceBundle;

/**
 * int	compare(T o1, T o2)
 *
 * static <T,U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T,? extends U> keyExtractor)
 *
 * default Comparator<T> thenComparing(Comparator<? super T> other)
 */
class ComparatorClass {
    private Thread thread;
    private LocalDateTime ldt;
    private ResourceBundle resourceBundle;

    private Comparator<ComparatorClass> comparatorByThread = Comparator.<ComparatorClass, Long>comparing(c -> c.thread.getId());
    private Comparator<ComparatorClass> comparatorByLdt = Comparator.<ComparatorClass, LocalDateTime>comparing(c -> c.ldt);
    private Comparator<ComparatorClass> comparatorByResourceBundle = Comparator.<ComparatorClass, Integer>comparing(c -> c.resourceBundle.keySet().size());

    private Comparator<ComparatorClass> comparator = comparatorByThread
            .thenComparing(comparatorByLdt)
            .thenComparing(comparatorByResourceBundle);

}
