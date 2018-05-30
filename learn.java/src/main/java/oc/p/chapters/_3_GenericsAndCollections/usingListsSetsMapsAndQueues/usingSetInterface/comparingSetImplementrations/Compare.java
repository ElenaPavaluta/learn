package oc.p.chapters._3_GenericsAndCollections.usingListsSetsMapsAndQueues.usingSetInterface.comparingSetImplementrations;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Compare {

    private final UnaryOperator<Character> unaryOperator = c -> new Character((char) (c + 1));

    /**
     * allow null elems (both for add and remove: has an internal function which assigns 0 to null.hashCode)
     */
    private Set<String> hashSet = new HashSet<>();

    /**
     * doesn't allow null neither for add or remove
     */
    private Set<String> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        Compare c = new Compare();

//        c.m();
//        c.m2();
//        c.m3();
        c.m4();
    }

    void m() {
        Set<String> set = Stream.iterate('a', unaryOperator)
                                .limit(26)
                                .map(String::valueOf)
                                .collect(Collectors.toCollection(HashSet::new));

        System.out.println(set.remove("23"));  //false
        System.out.println(set.add("bla bla car")); //true

        System.out.println(set.contains("e"));  //true
        System.out.println(set);
        System.out.println(set.hashCode());
        System.out.println(set.add(null)); //it inserts it as the first element
        System.out.println(set);

        System.out.println(set.remove(null));  //true, since exist, it removes it (how?)
        System.out.println(set);
    }

    void m2() {
        Object o = null;
        System.out.println(o.hashCode());  //NPE
    }

    void m3() {
        HashSet<String> set = new HashSet<>();
        System.out.println(set.add(null));  //true; because the inner implementation has a function that retrieves 0 for null
        System.out.println(set.add(null));  //false
    }

    void m4() {
        TreeSet<String> tree = Stream.iterate('a', unaryOperator)
                                     .limit(26)
                                     .map(String::valueOf)
                                     .collect(Collectors.toCollection(TreeSet::new));

//        System.out.println(tree.add(null));  //NPE
//        System.out.println(tree.remove(null));  //NPE

//        System.out.println(tree.remove(LocalDateTime.now()));  //ClassCastException

        System.out.println(tree.isEmpty());  //false

        System.out.println(tree.hashCode());
        System.out.println(treeSet.hashCode());
        System.out.println(new TreeSet<LocalDateTime>().hashCode());
    }




}
