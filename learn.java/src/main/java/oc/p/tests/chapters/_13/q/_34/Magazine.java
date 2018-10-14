package oc.p.tests.chapters._13.q._34;

import java.util.Set;
import java.util.TreeSet;

class Magazine implements Comparable<Magazine>{
    String name;

    Magazine(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Magazine o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Set<Magazine> set = new TreeSet <>();
        set.add(new Magazine("highlights"));
        set.add(new Magazine("Newsweek"));
        set.add(new Magazine("highlights"));
        System.out.println(set.iterator().next());
    }
}
