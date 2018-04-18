package oc.p.chapters.c3_GenericsAndCollections.searchingAndSorting.sortAndBinarySearch;
import java.util.Arrays;

import static oc.p.chapters.c3_GenericsAndCollections.searchingAndSorting.sortAndBinarySearch.CollectionsClass.comparator;

/**
 * static void	sort(Object[] a)
 *
 * static <T> void	sort(T[] a, Comparator<? super T> c)
 *
 * static int	binarySearch(Object[] a, Object key)
 *
 * static <T> int	binarySearch(T[] a, T key, Comparator<? super T> c)
 */
class ArraysClass {

    private static CollectionsClass.Rabbit[] array = {new CollectionsClass().new Rabbit(), new CollectionsClass().new Rabbit()};

    static void m(){
//        Arrays.sort(array);  //RE

        Arrays.sort(array, comparator);
    }

    static void m2(){
        CollectionsClass.Rabbit r = new CollectionsClass().new Rabbit();
//        Arrays.binarySearch(array, r);  //RE

        Arrays.binarySearch(array, comparator);
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
