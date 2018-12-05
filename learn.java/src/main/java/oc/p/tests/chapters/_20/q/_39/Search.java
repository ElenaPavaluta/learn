package oc.p.tests.chapters._20.q._39;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

class Search<T> {

    private List <T> data;
    private boolean foundMatch = false;

    Search(final List <T> data) {
        this.data = data;
    }

    static boolean m() {
        List <Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6);
        Search <Integer> search = new Search <>(data);
        search.exists(5, 0, data.size());
        return search.foundMatch;
    }

    static void m2() {
        Set <Boolean> set = new CopyOnWriteArraySet <>();
        for (int i = 0; i < 100000; i++) {
            set.add(m());
        }
        System.out.println(set);
    }

    public static void main(String[] args) {
        m2();
    }

    void exists(T value, int start, int end) {
        if (end - start <= 1) {
            foundMatch = foundMatch || value.equals(data.get(start));
        } else {
            final int middle = start + (end - start) / 2;
            new Thread(() -> exists(value, start, middle));
            new Thread(() -> exists(value, middle, end));
        }
    }
}
