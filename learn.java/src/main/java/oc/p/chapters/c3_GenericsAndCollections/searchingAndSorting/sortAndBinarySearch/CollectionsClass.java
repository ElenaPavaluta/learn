package oc.p.chapters.c3_GenericsAndCollections.searchingAndSorting.sortAndBinarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * static <T extends Comparable<? super T>> void sort(List<T> list)
 *
 * static <T> void	sort(List<T> list, Comparator<? super T> c)
 *
 * static <T> int	binarySearch(List<? extends Comparable<? super T>> list, T key)
 *
 * static <T> int	binarySearch(List<? extends T> list, T key, Comparator<? super T> c)
 */
class CollectionsClass {

    static Comparator<Rabbit> comparator = (r, r2) -> Integer.compare(r.hashCode(), r2.hashCode());
    private List<Rabbit> lst = Arrays.asList(new Rabbit(), new Rabbit());

    void m() {
//        Collections.sort(lst);  //compiler error

        Collections.sort(lst, comparator);

        lst.sort(comparator);
    }

    void m2() {
        Rabbit r = new Rabbit();

//        Collections.binarySearch(lst, r);  //compiler error

        Collections.binarySearch(lst, r, comparator);
    }

    class Rabbit {
    }
}
