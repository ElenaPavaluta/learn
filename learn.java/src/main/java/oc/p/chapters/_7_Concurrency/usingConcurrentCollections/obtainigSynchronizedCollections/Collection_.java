package oc.p.chapters._7_Concurrency.usingConcurrentCollections.obtainigSynchronizedCollections;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;

class Collection_ {

    Collection<Integer> c = Collections.synchronizedCollection(new ArrayDeque <>());
}
