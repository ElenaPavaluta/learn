package oc.p.chapters._7_Concurrency.usingConcurrentCollections.obtainigSynchronizedCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class List_ {

    List<Integer> list = Collections.synchronizedList(new ArrayList <>());
}
