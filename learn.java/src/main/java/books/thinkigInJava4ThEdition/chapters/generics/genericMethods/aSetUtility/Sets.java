package books.thinkigInJava4ThEdition.chapters.generics.genericMethods.aSetUtility;

import java.util.HashSet;
import java.util.Set;

class Sets {

    static <T> Set<T> union(Set<T> a, Set<T> b){
        Set<T> res = new HashSet<>(a);
        res.addAll(b);
        return res;
    }

    static <T> Set<T> intersection(Set<T> a, Set<T> b){
        Set<T> res = new HashSet<>(a);
        res.retainAll(b);
        return res;
    }

    static <T> Set<T> difference(Set<T> superset, Set<T> subset){
        Set<T> res = new HashSet<>(superset);
        res.removeAll(subset);
        return res;
    }

    static <T> Set<T> complement(Set<T> a, Set<T> b){
        return difference(union(a, b), intersection(a, b));
    }
}
