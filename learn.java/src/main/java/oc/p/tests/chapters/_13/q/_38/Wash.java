package oc.p.tests.chapters._13.q._38;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class Wash<T extends Collection> {
    T item;

    public static void main(String[] args) {
        Wash <List> w = new Wash <>();
        w.clean(Arrays.asList("a", "b"));
    }

    void clean(T items) {
        System.out.println("Cleaned: " + items.size());
    }
}
