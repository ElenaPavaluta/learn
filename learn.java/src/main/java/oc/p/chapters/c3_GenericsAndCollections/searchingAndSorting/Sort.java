package oc.p.chapters.c3_GenericsAndCollections.searchingAndSorting;

import java.util.Set;
import java.util.TreeSet;

/**
 * The sort method uses the compareTo() method to sort.
 * It expects the objects to be sorted to be Comparable
 */
class Sort {

    public static void main(String[] args) {
        Sort s = new Sort();
        s.m();
    }

    void m() {
        /**
         * TreeSet implements SortedSet (which requires the elements used by this set
         * to be of type Comparable)
         */
        Set<Rabbit> set = new TreeSet<>();
        set.add(new Rabbit());  //RE
    }

    void remember() {
        Sort.Rabbit r = new Sort().new Rabbit();
        r = this.new Rabbit();
        r = new Rabbit();
        Rabbit r2 = new Rabbit();

        Sort.Wolf w = new Sort.Wolf();
        w = new Wolf();

        Wolf w2 = new Wolf();
    }

    static void remember2(){
        Rabbit r = new Sort().new Rabbit();
        Sort.Rabbit r2 = new Sort().new Rabbit();

        Wolf w = new Sort.Wolf();
        w = new Wolf();
    }

    static class Wolf {
    }

    class Rabbit {
    }
}
