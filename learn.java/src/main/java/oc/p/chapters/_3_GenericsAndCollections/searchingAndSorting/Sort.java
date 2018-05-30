package oc.p.chapters._3_GenericsAndCollections.searchingAndSorting;

import java.util.*;

/**
 * The sort method uses the compareTo() method to sort.
 * It expects the objects to be sorted to be Comparable
 */
class Sort {

    public static void main(String[] args) {
        Sort s = new Sort();
//        s.m();
//        s.m2();
//        s.m3();
//        s.m4();
        s.m7();
    }

    void m() {
        /**
         * TreeSet implements SortedSet (which requires the elements used by this set
         * to be of type Comparable)
         */
        Set<Rabbit> set = new TreeSet<>();
        set.add(new Rabbit());  //RE
    }

    void m2(){
        TreeSet<Rabbit> set = new TreeSet<>((r, r2)->0);
        set.add(new Rabbit());
    }

    void m3(){
        TreeMap<Rabbit, String> map = new TreeMap<>((r, r2)->0);
        map.put(new Rabbit(), new String());
    }

    void m4(){
        Set<Wolf> set = new TreeSet<>();
        set.add(new Wolf());
    }

    /**
     * public static <T extends Comparable<? super T>> void sort(List<T> list)
     *
     * checks the type at compiler time, and if the type is Comparable: compiler error
     */
    void m5(){
        List<Rabbit> lst = new ArrayList<>();
        lst.add(new Rabbit());
        lst.add(new Rabbit());
//        Collections.sort(lst);  //compiler error
        Collections.sort(lst, (r, r2)->0);

        List<Wolf> lst2 = new ArrayList<>();
        lst2.add(new Wolf());
        lst2.add(new Wolf());
        Collections.sort(lst2);
    }

    void m6(){
        List<Rabbit> l = new ArrayList<>();
        l.add(new Rabbit());
        l.add(new Rabbit());
//        Collections.binarySearch(l, new Rabbit());  //compiler error
        Collections.binarySearch(l, new Rabbit(), (r, r2)->0);

        List<Wolf> l2 = new ArrayList<>();
        l2.add(new Wolf());
        l2.add(new Wolf());
        Collections.binarySearch(l2, new Wolf());
    }

    void m7(){
        Rabbit[] rs = new Rabbit[2];
        rs[0] = new Rabbit();
        rs[1] = new Rabbit();
//        Arrays.binarySearch(rs, new Rabbit());  //RE
        Arrays.binarySearch(rs, new Rabbit(), (r, r2)->0);
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

    static class Wolf implements Comparable<Wolf>{
        @Override
        public int compareTo(Wolf o) {
            return 0;
        }
    }

    class Rabbit {
    }
}
